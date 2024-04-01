package com.kiun.functionary.web.controller

import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.properties.FileProperties
import org.apache.tika.Tika
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileInputStream
import java.io.IOException

@RequestMapping("api/file")
@RestController
class FileController {

    @Autowired
    val fileProperty: FileProperties? = null

    @GetMapping("/{fileName}")
    fun get(@PathVariable("fileName") fileName: String) : ResponseEntity<InputStreamResource>{

        val tika = Tika()
        val file = File(fileProperty?.path, fileName);
        val resource = InputStreamResource(FileInputStream(file));

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
            .contentType(MediaType.valueOf(tika.detect(file)))
            .contentLength(file.length())
            .body(resource);
    }

    @PostMapping("/upload")
    @Throws(IOException::class)
    fun upload(@RequestParam file_upload: MultipartFile): DataWrap<String> {

        file_upload.transferTo(File(fileProperty?.path + "/" + file_upload.originalFilename))
        return DataWrap.success(file_upload.originalFilename)
    }
}
