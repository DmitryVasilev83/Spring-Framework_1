package ru.geekbrains.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.MessageProvider;
import ru.geekbrains.entity.Message;
import ru.geekbrains.service.MessageService;

@Controller
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    // форма для создания сообщения "/message/edit{id}"
    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String showSimpleForm(Model model){
        Message message = new Message();
        model.addAttribute("message", message);
        return "create-message";
    }

    // обработка формы создания и редактирования сообщения
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String processForm(Message message){
        if (message.getId()==null){
            messageService.save(message);
        }else {
            messageService.edit(message);
        }
        return "redirect:/message/all";
    }

    // показать один элемент
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)  // localhost:8080/spring/message/{id}?random=true
    public String getMessageById(Model model,
                                 @PathVariable Integer id,
                                 @RequestParam(name= "random", defaultValue = "false", required = false) Boolean isRandom){
        Message message;
        if (isRandom){
            System.out.println("1");
            message = messageService.getRandomMessage();
        }else {
            System.out.println("2");
            message = messageService.findById(id);
        }
        model.addAttribute("message", message);
        return "message";
    }


    // показать все элементы
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllMessages(Model model){
        model.addAttribute("messages", messageService.findAll());
        return "message-list";
    }

    // удаление элемента  "/message/delete{id}"
    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteById(@RequestParam Integer id){
        messageService.deleteByID(id);
        return "redirect:/message/all";
    }

    // редактирование элемента
    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editById(Model model, @RequestParam Integer id){
        Message message = messageService.findById(id);
        model.addAttribute("message", message);
        return "create-message";
    }



//    @RequestMapping
//    public String printMessage(Model model){
//        model.addAttribute("msg", messageProvider.getMessage());
//        model.addAttribute("info", "ADDED");
//        return "message";
//    }
//
//    @ModelAttribute("info1")
//    public String addAttribute(){
//        return "added info for all methods in controller";
//    }
}
