package com.car.show;

import com.car.show.Controller.ImageController;
import com.car.show.Service.CarImageService;
import com.car.show.Service.FirebaseService;
import com.google.cloud.storage.Blob;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.multipart.MultipartFile;


import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ImageController.class)
@AutoConfigureMockMvc
public class ImageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FirebaseService firebaseService;

    @MockBean
    private CarImageService carImageService;


    @Test
    public void testUploadImage() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test.jpg",
                "image/jpeg",
                "test image content".getBytes()
        );

        when(firebaseService.uploadFile(any(MultipartFile.class), eq(8)))
                .thenReturn("https://firebase.storage.url/test.jpg");

        mockMvc.perform(multipart("/images/upload")
                        .file(file)
                        .param("carId", "8")
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllFiles() throws Exception {
        Blob blob1 = Mockito.mock(Blob.class);
        Blob blob2 = Mockito.mock(Blob.class);
        Mockito.when(blob1.getName()).thenReturn("file1.jpg");
        Mockito.when(blob2.getName()).thenReturn("file2.jpg");

        List<Blob> blobs = Arrays.asList(blob1, blob2);
        Mockito.when(firebaseService.getAllFiles()).thenReturn(blobs);

        mockMvc.perform(MockMvcRequestBuilders.get("/images/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[\"file1.jpg\",\"file2.jpg\"]"));
    }
}
