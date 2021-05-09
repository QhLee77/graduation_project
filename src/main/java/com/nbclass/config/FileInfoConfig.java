package com.nbclass.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "file-info")
public class FileInfoConfig {
    private String fileDir;
    private Map<String,String> iconMap;
    private String temDir;

    public String getFileDir() {
        return fileDir;
    }

    public FileInfoConfig setFileDir(String fileDir) {
        this.fileDir = fileDir;
        return this;
    }

    public Map<String, String> getIconMap() {
        return iconMap;
    }

    public FileInfoConfig setIconMap(Map<String, String> iconMap) {
        this.iconMap = iconMap;
        return this;
    }

    public String getTemDir() {
        return temDir;
    }

    public FileInfoConfig setTemDir(String temDir) {
        this.temDir = temDir;
        return this;
    }
}
