package com.chatgptservice.microservice_chatgpt.controller;



import com.chatgptservice.microservice_chatgpt.model.ChatMessage;
import com.chatgptservice.microservice_chatgpt.model.request.ClientRequest;
import com.chatgptservice.microservice_chatgpt.model.response.ChatGptResponse;
import com.chatgptservice.microservice_chatgpt.service.ChatMessageService;
import com.chatgptservice.microservice_chatgpt.service.ClientServiceImpl;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.http.HttpHeaders;

import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

@RestController
@RequestMapping(value = "/api/Askchatgpt")
@RequiredArgsConstructor
public class ClientController {
    private final ClientServiceImpl clientService;

    @Autowired
    private ChatMessageService chatMessageService;

    @PostMapping("/send")
    public ChatGptResponse sendMessage(@RequestBody ClientRequest clientRequest) {
        return clientService.askQuestion(clientRequest);
    }
    @GetMapping("/export-to-csv")
    public void exportIntoCSV(HttpServletResponse response) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        String fileName = "chatGPT_Messages.csv";
        response.setContentType("text/csv");
        response.setHeader( CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");
        //response.addHeader("Content-Disposition", "attachment; filename=\"Messages.csv\"");
        //create a csv writer
        StatefulBeanToCsv<ChatMessage> writer = new StatefulBeanToCsvBuilder<ChatMessage>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR).withOrderedResults(false)
                .build();
        //write all employees data to csv file
        writer.write(chatMessageService.getMessageOfList());

    }

}
