package com.hrudzinskyi.View;

import com.hrudzinskyi.Controller.impl.*;
import com.hrudzinskyi.model.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

public class View {
    private static final String KEY_EXIT = "Quit";
    private final static Scanner scanner = new Scanner(System.in);
    private final Map<String, Printable> menu = new HashMap<>();

    private final TypeOfEquipmentController typeOfEquipmentController = new TypeOfEquipmentController();
    private final EquipmentController equipmentController = new EquipmentController();
    private final UserController userController = new UserController();
    private final LaserCutterController laserCutterController = new LaserCutterController();
    private final EquipmentTransferController equipmentTransferController = new EquipmentTransferController();
    private final RepairsWorkerController repairsWorkerController = new RepairsWorkerController();
    private final RepairController repairController = new RepairController();

    public View() {
        menu.put("11", this::getAllTypeOfEquipment);
        menu.put("12", this::getTypeOfEquipmentById);
        menu.put("13", this::createTypeOfEquipment);
        menu.put("14", this::updateTypeOfEquipment);
        menu.put("15", this::deleteTypeOfEquipment);

        menu.put("21", this::getAllEquipment);
        menu.put("22", this::getEquipmentById);
        menu.put("23", this::createEquipment);
        menu.put("24", this::updateEquipment);
        menu.put("25", this::deleteEquipment);

        menu.put("31", this::getAllUser);
        menu.put("32", this::getUserById);
        menu.put("33", this::createUser);
        menu.put("34", this::updateUser);
        menu.put("35", this::deleteUser);

        menu.put("41", this::getAllLaserCutter);
        menu.put("42", this::getLaserCutterById);
        menu.put("43", this::createLaserCutter);
        menu.put("44", this::updateLaserCutter);
        menu.put("45", this::deleteLaserCutter);

        menu.put("51", this::getAllEquipmentTransfer);
        menu.put("52", this::getEquipmentTransferById);
        menu.put("53", this::createEquipmentTransfer);
        menu.put("54", this::updateEquipmentTransfer);
        menu.put("55", this::deleteEquipmentTransfer);

        menu.put("61", this::getAllRepairsWorker);
        menu.put("62", this::getRepairsWorkerById);
        menu.put("63", this::createRepairsWorker);
        menu.put("64", this::updateRepairsWorker);
        menu.put("65", this::deleteRepairsWorker);

        menu.put("71", this::getAllRepair);
        menu.put("72", this::getRepairById);
        menu.put("73", this::createRepair);
        menu.put("74", this::updateRepair);
        menu.put("75", this::deleteRepair);
    }



    private void getAllTypeOfEquipment() throws SQLException {
        typeOfEquipmentController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getTypeOfEquipmentById() throws SQLException {
        out.println(typeOfEquipmentController.findById(getId()));
        massageItsAll();
    }

    private void createTypeOfEquipment() throws SQLException {
        typeOfEquipmentController.create(getTypeOfEquipmentFromInput());
        massageCreated();
    }

    private void updateTypeOfEquipment() throws SQLException {
        Integer id = getId();
        TypeOfEquipment typeOfEquipment = getTypeOfEquipmentFromInput();
        typeOfEquipment.setId(id);
        typeOfEquipmentController.update(typeOfEquipment.getId(), typeOfEquipment);
        massageUpdate();
    }

    private void deleteTypeOfEquipment() throws SQLException {
        typeOfEquipmentController.delete(getId());
        massageDeleted();
    }

    private TypeOfEquipment getTypeOfEquipmentFromInput() {
        out.println("Type:");
        String type = scanner.nextLine();
        return new TypeOfEquipment(type);
    }

    private void getAllEquipment() throws SQLException {
        equipmentController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getEquipmentById() throws SQLException {
        out.println(equipmentController.findById(getId()));
        massageItsAll();
    }

    private void createEquipment() throws SQLException {
        equipmentController.create(getEquipmentFromInput());
        massageCreated();
    }

    private void updateEquipment() throws SQLException {
        Integer id = getId();
        Equipment equipment = getEquipmentFromInput();
        equipment.setId(id);
        equipmentController.update(equipment.getId(), equipment);
        massageUpdate();
    }

    private void deleteEquipment() throws SQLException {
        equipmentController.delete(getId());
        massageDeleted();
    }

    private Equipment getEquipmentFromInput() {
        out.println("Inventory numbers id: ");
        Integer inventory_numbers = Integer.parseInt(scanner.nextLine());
        out.println("Color: ");
        String color = scanner.nextLine();
        out.println("Body material: ");
        String body_material = scanner.nextLine();
        out.println("Condition of equipment: ");
        String condition_of_equipment = scanner.nextLine();
        return new Equipment(inventory_numbers, color, body_material, condition_of_equipment);
    }

    private void getAllUser() throws SQLException {
        userController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getUserById() throws SQLException {
        out.println(userController.findById(getId()));
        massageItsAll();
    }

    private void createUser() throws SQLException {
        userController.create(getUserFromInput());
        massageCreated();
    }

    private void updateUser() throws SQLException {
        Integer id = getId();
        User user = getUserFromInput();
        user.setId(id);
        userController.update(user.getId(), user);
        massageUpdate();
    }

    private void deleteUser() throws SQLException {
        userController.delete(getId());
        massageDeleted();
    }

    private User getUserFromInput() {
        out.println("Surname: ");
        String surname = scanner.nextLine();
        out.println("Name: ");
        String name = scanner.nextLine();
        out.println("Student number: ");
        String student_number = scanner.nextLine();
        out.println("Zip: ");
        Integer zip = Integer.parseInt(scanner.nextLine());
        return new User(surname, name, student_number, zip);
    }

    private void getAllLaserCutter() throws SQLException {
        laserCutterController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getLaserCutterById() throws SQLException {
        out.println(laserCutterController.findById(getId()));
        massageItsAll();
    }

    private void createLaserCutter() throws SQLException {
        laserCutterController.create(getLaserCutterFromInput());
        massageCreated();
    }

    private void updateLaserCutter() throws SQLException {
        Integer id = getId();
        LaserCutter laserCutter = getLaserCutterFromInput();
        laserCutter.setId(id);
        laserCutterController.update(laserCutter.getId(), laserCutter);
        massageUpdate();
    }

    private void deleteLaserCutter() throws SQLException {
        laserCutterController.delete(getId());
        massageDeleted();
    }

    private LaserCutter getLaserCutterFromInput() {
        out.println("Time using: ");
        String time_using = scanner.nextLine();
        out.println("Start data: ");
        String start_data = scanner.nextLine();
        out.println("End data: ");
        String end_data = scanner.nextLine();
        out.println("Equipment id: ");
        Integer equipment_id = Integer.parseInt(scanner.nextLine());
        return new LaserCutter(time_using, start_data, end_data, equipment_id);
    }

    private void getAllEquipmentTransfer() throws SQLException {
        equipmentTransferController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getEquipmentTransferById() throws SQLException {
        out.println(equipmentTransferController.findById(getId()));
        massageItsAll();
    }

    private void createEquipmentTransfer() throws SQLException {
        equipmentTransferController.create(getEquipmentTransferFromInput());
        massageCreated();
    }

    private void updateEquipmentTransfer() throws SQLException {
        Integer id = getId();
        EquipmentTransfer equipmentTransfer = getEquipmentTransferFromInput();
        equipmentTransfer.setId(id);
        equipmentTransferController.update(equipmentTransfer.getId(), equipmentTransfer);
        massageUpdate();
    }

    private void deleteEquipmentTransfer() throws SQLException {
        equipmentTransferController.delete(getId());
        massageDeleted();
    }

    private EquipmentTransfer getEquipmentTransferFromInput() {
        out.println("Time: ");
        String time = scanner.nextLine();
        out.println("Start data: ");
        String start_data = scanner.nextLine();
        out.println("End data: ");
        String end_data = scanner.nextLine();
        return new EquipmentTransfer(time, start_data, end_data);
    }

    private void getAllRepairsWorker() throws SQLException {
        repairsWorkerController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getRepairsWorkerById() throws SQLException {
        out.println(repairsWorkerController.findById(getId()));
        massageItsAll();
    }

    private void createRepairsWorker() throws SQLException {
        repairsWorkerController.create(getRepairsWorkerFromInput());
        massageCreated();
    }

    private void updateRepairsWorker() throws SQLException {
        Integer id = getId();
        RepairsWorker repairsWorker = getRepairsWorkerFromInput();
        repairsWorker.setId(id);
        repairsWorkerController.update(repairsWorker.getId(), repairsWorker);
        massageUpdate();
    }

    private void deleteRepairsWorker() throws SQLException {
        repairsWorkerController.delete(getId());
        massageDeleted();
    }

    private RepairsWorker getRepairsWorkerFromInput() {
        out.println("Name: ");
        String name = scanner.nextLine();
        out.println("Surname: ");
        String surname = scanner.nextLine();
        return new RepairsWorker(name, surname);
    }

    private void getAllRepair() throws SQLException {
        repairController.findAll().forEach(out::println);
        massageItsAll();
    }

    private void getRepairById() throws SQLException {
        out.println(repairController.findById(getId()));
        massageItsAll();
    }

    private void createRepair() throws SQLException {
        repairController.create(getRepairFromInput());
        massageCreated();
    }

    private void updateRepair() throws SQLException {
        Integer id = getId();
        Repair repair = getRepairFromInput();
        repair.setId(id);
        repairController.update(repair.getId(), repair);
        massageUpdate();
    }

    private void deleteRepair() throws SQLException {
        repairController.delete(getId());
        massageDeleted();
    }

    private Repair getRepairFromInput() {
        out.println("Time: ");
        String time = scanner.nextLine();
        out.println("Start data: ");
        String start_data = scanner.nextLine();
        out.println("End data: ");
        String end_data = scanner.nextLine();
        out.println("Repairs worker id: ");
        Integer repairs_worker_id = Integer.parseInt(scanner.nextLine());
        out.println("Equipment id: ");
        Integer equipment_id = Integer.parseInt(scanner.nextLine());
        out.println("Repairs worker id1: ");
        Integer repairs_worker_id1 = Integer.parseInt(scanner.nextLine());
        return new Repair(time, start_data, end_data, repairs_worker_id, equipment_id, repairs_worker_id1);
    }

    private Integer getId() {
        out.println("Id:");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    private String getType() {
        out.println("Type:");
        return scanner.nextLine();
    }

    private void massageItsAll() {
        out.println("----------------------------------------\n"
                + "That's all!\n"
                + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageDeleted() {
        out.println("Deleted!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageCreated() {
        out.println("Created!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageUpdate() {
        out.println("Update!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private static void displayMenu() {
        out.println(
                "|--------------------------------------|---------------|\n" +
                        "| 1: type_of_equipment                 |   1: GET ALL  |\n" +
                        "| 2: equipment                         |   2: GET      |\n" +
                        "| 3: user                              |   3: CREATE   |\n" +
                        "| 4: laser_cutter                      |   4: UPDATE   |\n" +
                        "| 5: equipment_transfer                |   5: DELETE   |\n" +
                        "| 6: repairs_worker                    |_______________|\n" +
                        "| 7: repair                            |   Quit - exit |\n" +
                        "|--------------------------------------|---------------|\n"
        );
    }

    public void show() throws SQLException {
        displayMenu();
        out.println("Select a table and action: ");
        String input = scanner.nextLine();

        while (!input.equals(KEY_EXIT)) {
            out.println("----------------------------------------");
            menu.get(input).print();
            input = scanner.nextLine();
        }
    }
}
