package com.product.dto;

import com.product.model.media.Media;
import lombok.*;

import java.io.InputStream;
import java.io.Serializable;

/**
 * DTO for {@link Media}
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MediaDto implements Serializable {
    private InputStream inputStream;
    private String fileName;
}