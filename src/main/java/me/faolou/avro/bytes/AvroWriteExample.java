package me.faolou.avro.bytes;

import me.faolou.avro.User;
import org.apache.avro.io.*;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Apache avro data bytes serializing example
 * Created by zhangkai on 9/24/14.
 */
public class AvroWriteExample {

    public static void main(String[] args) throws Exception{
        User user = User.newBuilder()
                .setName("James")
                .setFavoriteNumber(10)
                .setFavoriteColor("Black")
                .build();

        FileOutputStream fos = FileUtils.openOutputStream(new File("user_avro.bin"));

        DatumWriter<User> datumWriter = new SpecificDatumWriter<User>();
        Encoder encoder = EncoderFactory.get().binaryEncoder(fos, null);

        datumWriter.write(user,encoder);

        IOUtils.closeQuietly(fos);
    }
}
