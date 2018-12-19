package com.otus.shared.services;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Service
public class CsvServiceImpl implements CsvService {

    private final Logger logger = LoggerFactory.getLogger(CsvServiceImpl.class);

    public <T> List<T> readCsv(Class<T> type, String fileName) {

        try {
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues = mapper.reader(type).with(schema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            logger.info("Error occurred while loading object list from file " + fileName, e);
        }

        return Collections.emptyList();
    }
}
