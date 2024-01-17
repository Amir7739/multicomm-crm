// package com.fintech.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.Lob;
// import jakarta.persistence.ManyToOne;
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Entity
// @Getter
// @Setter
// @AllArgsConstructor
// @NoArgsConstructor
// public class UploadedFile {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String fileName;

//     @Lob
//     private byte[] fileContent;

//     @ManyToOne
//     @JoinColumn(name = "case_login_id")
//     private CaseLogin caseLogin;
// }

