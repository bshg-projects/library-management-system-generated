package org.bshg.librarysystem.author.webservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.authorbook.webservice.AuthorBookDto;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;

import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorDto extends AuditBaseDto {
    public AuthorDto() {
        super();
    }

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String nationality;
    private String biography;
    private List<AuthorBookDto> authorBook;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate value) {
        this.dateOfBirth = value;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String value) {
        this.nationality = value;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String value) {
        this.biography = value;
    }

    public List<AuthorBookDto> getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(List<AuthorBookDto> value) {
        this.authorBook = value;
    }
}