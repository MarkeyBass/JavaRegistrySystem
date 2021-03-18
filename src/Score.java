

public class Score {
    private String course;
    private Integer value;

    public Score(String course, Integer value) {
        setCourse(course);
        setValue(value);
    }

    // Getters and Setters
    public String getCourse() {
        return course;
    }

    public Integer getValue() {
        return value;
    }


    public void setCourse(String course) {
        this.course = course.toUpperCase().charAt(0) + course.toLowerCase().substring(1);
    }

    public void setValue(Integer value) {
        if (value < 0) {
            this.value = 0;
        } else if (value > 100) {
            this.value = 100;
        } else {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        return "Score{" +
                "course='" + course + '\'' +
                ", value=" + value +
                '}';
    }
}
