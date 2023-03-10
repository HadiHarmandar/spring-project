package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentService {

    private final CommentRepository dbCommentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRepository dbCommentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.dbCommentRepository = dbCommentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        // save in the DB
        dbCommentRepository.storeComment(comment);
        // send email
        commentNotificationProxy.sendComment(comment);
    }
}
