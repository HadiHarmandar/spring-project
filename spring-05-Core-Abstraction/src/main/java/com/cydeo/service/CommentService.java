package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;

public class CommentService {

    private CommentRepository dbCommentRepository;
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment) {
        // save in the DB
        dbCommentRepository.storeComment(comment);
        // send email
        commentNotificationProxy.sendComment(comment);
    }
}
