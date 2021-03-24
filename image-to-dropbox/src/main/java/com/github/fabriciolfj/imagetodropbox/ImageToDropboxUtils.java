package com.github.fabriciolfj.imagetodropbox;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@Log4j2
public class ImageToDropboxUtils {

    private ImageToDropboxProperties imageToDropboxProperties;
    private DbxClientV2 client;

    public ImageToDropboxUtils(ImageToDropboxProperties properties) {
        this.imageToDropboxProperties = properties;
        DbxRequestConfig config = DbxRequestConfig.newBuilder("673lf5mqcfhbdcc").build();
        this.client = new DbxClientV2(config, this.imageToDropboxProperties.getApiKey());
    }

    public void fromUrlToDropBox(String fromUrl, String fileName) throws IOException, DbxException {
        log.debug("Attempting to download: {}", fromUrl);
        FileUtils.copyURLToFile(new URL(fromUrl), new File(this.imageToDropboxProperties.getLocalTmpFolder() + fileName), 10000,10000);
        InputStream in = new FileInputStream(this.imageToDropboxProperties.getLocalTmpFolder() + fileName);
        log.debug("Attempting to save to dropbox in {}", this.imageToDropboxProperties.getPath() + fileName);
        //client.files()
         //       .uploadBuilder(this.imageToDropboxProperties.getPath() + fileName)
          //      .uploadAndFinish(in);
        log.debug("Uploaded to dropbox");

        FileUtils.deleteQuietly(new File(this.imageToDropboxProperties.getLocalTmpFolder() + fileName));
    }
}
