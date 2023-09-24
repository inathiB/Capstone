package com.example.demo.Email;
import com.example.demo.Collection.Course;
import com.example.demo.Collection.Tutor;
import com.example.demo.Collection.Tutorial;
import com.example.demo.Collection.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailService {
        private final JavaMailSender javaMailSender;
        public EmailService(JavaMailSender javaMailSender) {
            this.javaMailSender = javaMailSender;
        }
        public void sendRegisterationConfirmation(String to, User user) throws MessagingException {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom("mytutorwebsitecs@gmail.com");
            mimeMessageHelper.setTo(to);

            mimeMessageHelper.setText("Hello, You have successfully registered on the myTutor website.");
            mimeMessageHelper.setSubject("MyTutor Website Registration Confirmation");

            javaMailSender.send(mimeMessage);

        }

    public void addedToCourseTutor(String to) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("mytutorwebsitecs@gmail.com");
        mimeMessageHelper.setTo(to);
        String htmlContent = "<html><body style='background-color: #E0F2F1; font-family: Arial, sans-serif;'>"
                + "<p style='font-size: 16px; color: #333;'>Hello <strong style='color: #007BFF;'>B🌻</strong>,</p>"
                + "<p style='font-size: 14px;'>This is what Rea has been working on this morning.</p>"
                + "</body></html>";
        mimeMessageHelper.setText(htmlContent,true);
        mimeMessageHelper.setSubject("You have been appointed as a Tutor");

        javaMailSender.send(mimeMessage);

        System.out.println("Mail sent to Inathi");
    }


    public void sendAdditionCourseconvener(Optional<Course> course, String courseConvener) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("mytutorwebsitecs@gmail.com");
        mimeMessageHelper.setTo(courseConvener);

        mimeMessageHelper.setText("Good day, \n You have been added to "+course.get().getCourseName()+" page in the MyTutor Management System.");
        mimeMessageHelper.setSubject("You are a "+course.get().getCourseCode()+" Course Convener ");

        javaMailSender.send(mimeMessage);

    }

    public void sendTutorEmail(Tutor tutor) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("mytutorwebsitecs@gmail.com");
        mimeMessageHelper.setTo(tutor.getStudentID()+"@myuct.ac.za");

        mimeMessageHelper.setText("Good day " +tutor.getName()+ tutor.getName()+" \nCongratulations on your appointment as a Tutor. Check the myTutor website for more details on the appointment");
        mimeMessageHelper.setSubject("Tutor Appointment");

        javaMailSender.send(mimeMessage);
    }

    public void sendTutorialAddition(Tutor tutor, Optional<Tutorial> tutorial) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("mytutorwebsitecs@gmail.com");
        mimeMessageHelper.setTo(tutor.getStudentID()+"@myuct.ac.za");

        mimeMessageHelper.setText("Good day, \n You have signed up for the " + tutorial.get().getCourseCode() +" tutorial on "+ tutorial.get().getDayOfWeek()+" "+ tutorial.get().getTime() +" at " +tutorial.get().getVenue() +".");
        mimeMessageHelper.setSubject(" Tutorial Sign up Confirmation ");

        javaMailSender.send(mimeMessage);
    }
}

