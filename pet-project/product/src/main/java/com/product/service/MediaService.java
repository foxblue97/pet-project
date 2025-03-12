package com.product.service;

import com.product.config.ServiceConfig;
import com.product.viewmodel.media.NoMediaVm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
public class MediaService {
    private RestClient restClient;
    private ServiceConfig serviceUrlConfig;

//
//    public NoMediaVm saveMedia(MultipartFile multipartFile,String caption,String overrideFile) {
//
//
//    }



}
