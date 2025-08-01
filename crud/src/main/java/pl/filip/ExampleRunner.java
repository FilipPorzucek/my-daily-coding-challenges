package pl.filip;

public class ExampleRunner {

    public static void main(String[] args) {
        CustomerRepository customerRepository=new CustomerRepository();
        customerRepository.deleteAll();

        Customer customer1 =  customerRepository.insertCustomer(ExampleData.someCustomer1());
        Customer customer2=customerRepository.insertCustomer(ExampleData.someCustomer2());

        customerRepository.criteriaExample();



        HibernateUtil.closeSessionFactory();



        /*customerRepository.listCustomers()
                .forEach(customer -> System.out.println("Customer list: "+customer));

        System.out.println("Customer1"+customerRepository.getCustomer(customer1.getId()));
        System.out.println("Customer2"+customerRepository.getCustomer(customer2.getId()));

       Address newAdress=Address.builder().country("Poland").city("Poznan")
                .postalCode("81-123").address("Hlynska2").build();
        customerRepository.updateCustomer(customer1.getId(),newAdress);
        System.out.println("Update customer"+customerRepository.getCustomer(customer1.getId()));

        customerRepository.listCustomers()
.forEach(customer -> System.out.println("Customer lisyt"+customer));
*/




    }

}
