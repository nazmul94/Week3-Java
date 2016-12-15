package addressBookProgramme.models;


public class Contact
{
    //Fields
    private int id;
    private long phoneNumber;

    private Person person = new Person();
    private Address address = new Address();

    //Constructor
    public Contact(int id, String firstName, String lastName, int phoneNumber, String street, String city, String postCode, String country)
    {
        this.id = id;
        person.setFirstName(firstName);
        person.setLastName(lastName);
        this.phoneNumber = phoneNumber;
        address.setStreet(street);
        address.setCity(city);
        address.setPostCode(postCode);
        address.setCountry(country);
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    //Methods
    @Override
    public String toString()
    {
        return String.format("Contact: %s %s %s %s %s %s %s %s",
                this.id,
                person.getFirstName(),
                person.getLastName(),
                this.phoneNumber,
                address.getStreet(),
                address.getCity(),
                address.getPostCode(),
                address.getCountry());
    }
}
