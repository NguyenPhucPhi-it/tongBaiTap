package quanlysinhvienvku;

public class Student {
    private int studentID;
    private String name;
    private int age;
    private String email;
    private float gpa;

    public Student(int studentID, String name, int age, float gpa) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.email = generateEmail(name);
    }
   
    public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}
{
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	private String generateEmail(String fullName) {
        String[] parts = fullName.toLowerCase().split(" ");
        String email = parts[parts.length - 1] + "." + parts[0].charAt(0) + "@vku.udn.vn";
        return email;
    }

}