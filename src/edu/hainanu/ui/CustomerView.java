package edu.hainanu.ui;


import edu.hainanu.bean.Customer;
import edu.hainanu.service.CustomerList;
import edu.hainanu.util.CMUtility;

/**
 * @author 9527 Email：839119912@qq.com
 * @version 1.0
 * @Describtion CustomerView 负责菜单的显示的处理用户操作
 * @date 2020/8/18
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("刘乐", '男', 23, "13213452345", "liule@gmail.com");
        customerList.addCustomer(customer);
    }

    public void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("\n----------客户信息管理----------");
            System.out.println("----------1  添加客户----------");
            System.out.println("----------2  修改客户----------");
            System.out.println("----------3  删除客户----------");
            System.out.println("----------4  列出客户----------");
            System.out.println("----------5   退出  ----------");
            System.out.print("请选择（1-5）：");
            char menu = CMUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("确认是否推出(Y/N)");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
                    break;
            }
        }

    }

    private void addNewCustomer() {
        System.out.println("----------添加客户----------");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);

        System.out.print("性别：");
        char gender = CMUtility.readChar();

        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱：");
        String email = CMUtility.readString(30);

        Customer customer = new Customer(name, gender, age, phone, email);

        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("----------添加完成----------");
        } else {
            System.out.println("----------添加失败----------");
        }
    }

    private void modifyCustomer() {
        System.out.println("----------修改客户----------");
        System.out.println("请输入待修改客户编号（-1退出）：");
        Customer cust;
        int number;
        boolean isReplaced;
        for (; ; ) {
            number = CMUtility.readInt();

            if (number == -1) {
                return;
            }

            cust = customerList.getCustomer(number - 1);
            if (cust == null) {
                isReplaced = false;
                System.out.println("----------无法找到客户----------");
            } else {
                isReplaced = true;
                break;
            }
        }

        System.out.print("姓名(" + cust.getName() + "):");
        String name = CMUtility.readString(10, cust.getName());
        System.out.print("性别(" + cust.getGender() + "):");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄(" + cust.getAge() + "):");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("电话(" + cust.getPhone() + "):");
        String phone = CMUtility.readString(13, cust.getPhone());
        System.out.print("邮箱(" + cust.getEmail() + "):");
        String email = CMUtility.readString(30, cust.getEmail());

        Customer newCust = new Customer(name, gender, age, phone, email);
        customerList.replaceCustomer(number - 1, newCust);
        if (isReplaced) {
            System.out.println("----------修改完成----------");
        } else {
            System.out.println("----------修改失败----------");
        }

    }

    private void deleteCustomer() {
        System.out.println("----------删除用户----------");
        System.out.println("请输入待删除客户编号（-1退出）：");
        int number;

        for (; ; ) {
            number = CMUtility.readInt();

            if (number == -1) {
                return;
            }

            if (number < 0 || number > customerList.getTotal()) {
                System.out.println("----------无法找到客户----------");
            } else {
                System.out.println("确认是否推出(Y/N)");
                char isExit = CMUtility.readConfirmSelection();
                if (isExit == 'Y') {
                    customerList.deleteCustomer(number - 1);
                    System.out.println("----------删除完成----------");
                    break;
                } else {
                    System.out.println("----------删除失败----------");
                    return;
                }

            }

        }
    }

    private void listAllCustomers() {
        System.out.println("----------客户列表----------");
        int total = customerList.getTotal();
        if (total < 0) {
            System.out.println("没有客户记录");
        } else {
            System.out.println("编号"+"\t"+"姓名"+"\t"+"性别"+"\t"+"年龄"+"\t"+"电话        "+"\t"+"邮箱");
            Customer[] custs = customerList.getAllCustomers();
            for (int i = 0; i < total; i++) {
                Customer cust = custs[i];
                System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge() + "\t" + cust.getPhone() + "\t" + cust.getEmail());
            }
        }
        System.out.println("----------客户列表完成----------");

    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
