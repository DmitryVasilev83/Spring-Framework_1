package ru.geekbrains.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.entity.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MessageRepository {

    List<Message> messages = new ArrayList<>();

    private int count = 0;

    public Message save(Message message){
        message.setId(count++);
        messages.add(message);

        // заворачиваем в билдер(из ломбока) для безопасности. ВОзвращаем не само сообщение а его копию
        // так надо делать во всех методах ниже, где это не сделано на уроке для краткости
        return Message.builder()
                .id(message.getId())
                .from(message.getFrom())
                .to(message.getTo())
                .body(message.getBody())
                .build();
    }

    public Message edit(Message message){
        return messages.set(message.getId(), message);
    }

    public Optional<Message>  findById(Integer id){
        if (id < messages.size()){
              //   System.out.println("1. " + id + messages.size());
            return Optional.of(messages.get(id));

        }else {
            //   System.out.println("2. " + id + messages.size());
            return Optional.empty();
        }
    }

    public List<Message> findAll(){
        return new ArrayList<>(messages);
    }

    public void deleteByID(Integer id){
        if (id < messages.size()){
            messages.remove(id.intValue());
        }
    }


}
