package hr.fer.zemris.java.tecaj.hw6.demo5;

import java.util.Comparator;

/**
 * {@code StudentRecord} is a class containing some info about student.
 * <p>
 * This class contains:
 * <ul>
 * <li>JMBAG
 * <li>Last name
 * <li>First name
 * <li>Number of points earned at midterm exam
 * <li>Number of points earned at final exam
 * <li>Number of points earned at lab
 * <li>Final grade
 * </ul>
 * 
 * @author Karlo Vrbić
 * @version 1.0
 */
public class StudentRecord {

    /** JMBAG of student */
    private String jmbag;

    /** Last name of student */
    private String lastName;

    /** First name of student */
    private String firstName;

    /** Number of points earned at midterm exam. */
    private Double mi;

    /** Number of points earned at final exam. */
    private Double zi;

    /** Number of points earned at lab. */
    private Double lab;

    /** Final grade of student */
    private Integer grade;

    /**
     * Comparator that compares one {@code StudentRecord} to another using only
     * their JMBAG. It's usually used for sorting and lowest JMBAG will be
     * first.
     */
    public static final Comparator<StudentRecord> BY_JMBAG = (s1, s2) -> s1
            .getJMBAG()
            .compareTo(s2.getJMBAG());

    /**
     * Comparator that compares one {@code StudentRecord} to another using only
     * their sum of points earned at midterm exam, final exam and lab. It's
     * usually used for sorting and highest number of points will be first.
     */
    public static final Comparator<StudentRecord> BY_TOTAL_POINTS = (s1, s2) -> s2
            .getTotalPoints()
            .compareTo(s1.getTotalPoints());

    /**
     * Constructs a new {@code StudentRecord} object from specified JMBAG, last
     * name, first name and final grade.
     * 
     * @param jmbag
     *            JMBAG of student
     * @param lastName
     *            last name of student
     * @param firstName
     *            first name of student
     * @param mi
     *            number of points earned at midterm exam
     * @param zi
     *            number of points earned at final exam
     * @param lab
     *            number of points earned at lab
     * @param grade
     *            final grade of student
     */
    public StudentRecord(String jmbag, String lastName, String firstName, double mi, double zi,
            double lab, int grade) {

        if (jmbag == null || lastName == null || firstName == null) {
            throw new IllegalArgumentException("One of the arguments is null!");
        }

        if (!jmbag.matches("^[0-9]{10}$")) {
            throw new IllegalArgumentException("JMBAG must consist of 10 digits!");
        }

        /*
         * Inace ovo provjerava ispravnost imena i prezimena ali su u zadataku
         * zadana imena i prezimena sa brojevima
         *
         * if (!lastName.matches( "^\\p{L}[\\p{L} ,\\.'-]*$")) { throw new
         * IllegalArgumentException( "Invalid last name!"); } if
         * (!firstName.matches( "^\\p{L}[\\p{L} ,\\.'-]*$")) { throw new
         * IllegalArgumentException( "Invalid first name!"); }
         */

        if (mi < 0) {
            throw new IllegalArgumentException(
                    "Number of points earned at midterm exam must be non-negative!");
        }
        if (zi < 0) {
            throw new IllegalArgumentException(
                    "Number of points earned at final exam must be non-negative!");
        }
        if (lab < 0) {
            throw new IllegalArgumentException(
                    "Number of points earned at lab must be non-negative!");
        }
        if (grade > 5 || grade < 1) {
            throw new IllegalArgumentException(
                    "Final grade must be integer value between 1 and 5!");
        }

        this.jmbag = jmbag;
        this.lastName = lastName;
        this.firstName = firstName;
        this.mi = mi;
        this.zi = zi;
        this.lab = lab;
        this.grade = grade;
    }

    /**
     * Returns the JMBAG of a student
     * 
     * @return the JMBAG of a student
     */
    public String getJMBAG() {
        return jmbag;
    }

    /**
     * Returns the last name of a student
     * 
     * @return the last name of a student
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the first name of a student
     * 
     * @return the first name of a student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the number of points earned at midterm exam
     * 
     * @return number of points earned at midterm exam
     */
    public Double getMI() {
        return mi;
    }

    /**
     * Returns the number of points earned at lab
     * 
     * @return number of points earned at lab
     */
    public Double getZI() {
        return zi;
    }

    /**
     * Returns the number of points earned at lab
     * 
     * @return number of points earned at lab
     */
    public Double getLab() {
        return lab;
    }

    /**
     * Returns the number of points earned at lab
     * 
     * @return number of points earned at lab
     */
    public Double getTotalPoints() {
        return mi + zi + lab;
    }

    /**
     * Returns the final grade of a student
     * 
     * @return the final grade of a student
     */
    public Integer getGrade() {
        return grade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((jmbag == null) ? 0 : jmbag.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StudentRecord other = (StudentRecord) obj;
        if (jmbag == null) {
            if (other.jmbag != null)
                return false;
        } else if (!jmbag.equals(other.jmbag))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return jmbag + "\t" + lastName + "\t" + firstName + "\t" + mi + "\t" + zi + "\t" + lab
                + "\t" + grade;
    }

    /**
     * Factory method for getting StudentRecord from {@code String}
     * representation of a record and a separator.(for example comma-separated
     * file, tab-separated file)
     * 
     * @param str
     *            {@code String} representation of a record
     * @param separator
     *            separator between student attributes
     * @return new {@code StudentRecord} object containing all information about
     *         the student
     */
    public static StudentRecord fromString(String str, String separator) {
        if (str == null || separator == null) {
            throw new IllegalArgumentException("Both arguments must be non-null string references");
        }

        if (str.isEmpty()) {
            return null;
        }

        String[] args = str.split(separator);

        if (args.length != 7) {
            throw new IllegalArgumentException(
                    "You need to input string with 7 arguments separated by"
                            + " separator you define!");
        }

        StudentRecord rec;

        try {
            rec = new StudentRecord(
                    args[0],
                    args[1],
                    args[2],
                    Double.parseDouble(args[3]),
                    Double.parseDouble(args[4]),
                    Double.parseDouble(args[5]),
                    Integer.parseInt(args[6]));

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("4th argument must be integer between 1 and 5!");
        }

        return rec;
    }
}