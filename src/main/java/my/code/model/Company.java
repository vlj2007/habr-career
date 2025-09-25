package my.code.model;

public class Company {
    private String title;
    private String rating;
    private String vacancies;
    private String skills;
    private String links;

    public Company() {
    }

    public Company(String title, String rating, String vacancies, String skills, String links) {
        this.title = title;
        this.rating = rating;
        this.vacancies = vacancies;
        this.skills = skills;
        this.links = links;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getVacancies() {
        return vacancies;
    }

    public void setVacancies(String vacancies) {
        this.vacancies = vacancies;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "{\"title\":\"" + title + "\", " +
                "\"rating\":\"" + rating + "\", " +
                "\"vacancies\":\"" + vacancies + "\", " +
                "\"skills\":\"" + skills + "\", " +
                "\"links\":\"" + links + "\"}";
    }

}
