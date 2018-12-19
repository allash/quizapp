package com.otus.shared.services;

import java.util.List;

public interface CsvService {
    <T> List<T> readCsv(Class<T> type, String fileName);
}
