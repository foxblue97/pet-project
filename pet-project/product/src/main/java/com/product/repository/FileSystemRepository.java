package com.product.repository;

import java.io.File;

public class FileSystemRepository {










    public void checkPermission(File file) throws IllegalAccessException {
        if(!file.canExecute() || !file.canWrite()){
            throw new IllegalAccessException("File can't execute or write");
        }
    }

    public void checkDirectory(File file) throws IllegalAccessException {
        if(!file.isDirectory()){
            throw new IllegalAccessException("File is not a directory");
        }
    }


}
