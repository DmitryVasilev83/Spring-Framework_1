package ru.geekbrains.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import ru.geekbrains.MessageProvider;
import ru.geekbrains.entity.Message;
import ru.geekbrains.repository.MessageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {

    public final MessageRepository messageRepository;

    public Message save(Message message){
        return messageRepository.save(message);
    }

    public Message edit(Message message){
        return messageRepository.edit(message);
    }

    public Message findById(Integer id){

        return messageRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public void deleteByID(Integer id){
        messageRepository.deleteByID(id);
    }

    public Message getRandomMessage(){
        return Message.builder()
                .body(getMessageProvider().getMessage())
                .from("Randomized")
                .to("Browser")
                .build();
    }

    @Lookup
    public MessageProvider getMessageProvider(){
        return null;
    }
}
