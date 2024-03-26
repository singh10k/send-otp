package com.email.in.service.imp;

import com.email.in.dto.SendOtpMailDto;
import com.email.in.exceptions.MassageErrorException;
import com.email.in.repository.EmailConfigRepository;
import com.email.in.service.SendOtpMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class SendOtpMailServiceImp implements SendOtpMailService {
    final private EmailConfigRepository emailConfigRepository;
    @Override
    public List<String> sendOtp(SendOtpMailDto request) {
        List<String> resultList=new ArrayList<>();
        emailConfigRepository.findAllByMailConfigId(request.getMailId()).ifPresentOrElse(
                (mailConfig) -> {
                    // Your action when email configurations are found
                    // For example:
                    String recipientEmail = request.getToMail();
                    // Generate OTP
                    Random random = new Random();
                    int otpValue = 1000 + random.nextInt(9000);
                    String otp = String.valueOf(otpValue);

                    // Sender's email address and password
                    final String senderEmail = mailConfig.getFromMail();
                    final String password = mailConfig.getPassword();

                    // Sending email
                    Properties props = new Properties();
                    props.put("mail.smtp.auth", mailConfig.getMailSmtpAuth());
                    props.put("mail.smtp.starttls.enable", mailConfig.getMailSmtpStarttlsEnable());
                    props.put("mail.smtp.host", mailConfig.getMailSmtpHost()); // Your SMTP server
                    props.put("mail.smtp.port", mailConfig.getMailSmtpPort()); // SMTP port (typically 587 for TLS/STARTTLS)

                    Session session = Session.getInstance(props, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(senderEmail, password);
                        }
                    });

                    try {
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(senderEmail));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
                        message.setSubject("Your OTP");
                        message.setText("Your One-Time Password (OTP) is: " + otp);

                        Transport.send(message);
                        resultList.add(otp);
                        resultList.add("OTP sent successfully.");
                        System.out.println("OTP sent successfully.");

                    } catch (MessagingException e) {
                        throw new MassageErrorException("Failed to write workbook content to file: " + e.getMessage());
                    }
                    System.out.println("Email configurations found: " + mailConfig);
                },
                () -> {
                    // Your action when no email configurations are found
                    // For example:
                    resultList.add("No email configurations found for the specified ID");
                    System.out.println("No email configurations found for the specified ID");
                }
        );
        return resultList;
    }
}
