package com.product.model.media;

import com.product.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caption;
    private String fileName;
    private String filePath;
    private String fileType;


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Media media)) return false;
        return Objects.equals(getId(), media.getId()) && Objects.equals(getCaption(), media.getCaption()) && Objects.equals(getFileName(), media.getFileName()) && Objects.equals(getFilePath(), media.getFilePath()) && Objects.equals(getFileType(), media.getFileType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCaption(), getFileName(), getFilePath(), getFileType());
    }
}
