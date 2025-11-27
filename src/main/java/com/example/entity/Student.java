    package com.example.entity;

    import jakarta.persistence.*;
    import lombok.*;

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Table(name="student")
    public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long studentId;

        private String studentName;

        private Integer studentAge;

        private String  address;

        private String gender;

        private String collegeName;

        private String email;

        private String mobileNo;
    }
