package com.hrudzinskyi.view;

import com.hrudzinskyi.controller.Controller;

import com.hrudzinskyi.controller.impl.*;
import com.hrudzinskyi.model.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final static Scanner scanner = new Scanner(System.in);
    private final Map<String, Printable> menu = new HashMap<String, Printable>();

    private final Controller typeOfEquipmentController = new TypeOfEquipmentController();
    private final Controller equipmentController = new EquipmentController();
    private final Controller userController = new UserController();
    private final Controller laserCutterController = new LaserCutterController();
    private final Controller equipmentTransferController = new EquipmentTransferController();
    private final Controller repairsWorkerController = new RepairsWorkerController();
    private final Controller repairController = new RepairController();

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
        System.out.println("");
        typeOfEquipmentController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getTypeOfEquipmentById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        System.out.println("\n" + typeOfEquipmentController.findById(id));
        System.out.println("");
    }

    private void createTypeOfEquipment() throws SQLException {
        System.out.println("");
        typeOfEquipmentController.create(getTypeOfEquipmentFromInput());
        System.out.println("");
    }

    private void updateTypeOfEquipment() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        TypeOfEquipment typeOfEquipment = getTypeOfEquipmentFromInput();
        typeOfEquipment.setId(id);
        typeOfEquipmentController.update(typeOfEquipment);
        System.out.println("");

    }

    private void deleteTypeOfEquipment() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        typeOfEquipmentController.delete(id);
        System.out.println("");
    }

    private TypeOfEquipment getTypeOfEquipmentFromInput() {
        System.out.println("Type type:");
        String type = scanner.nextLine().replaceAll(" ", "");

        return new TypeOfEquipment(type);
    }

    private void getAllEquipment() throws SQLException {
        System.out.println("");
        equipmentController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getEquipmentById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        System.out.println("\n" + equipmentController.findById(id));
        System.out.println("");
    }

    private void createEquipment() throws SQLException {
        System.out.println("");
        equipmentController.create(getEquipmentFromInput());
        System.out.println("");
    }

    private void updateEquipment() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        Equipment equipment = getEquipmentFromInput();
        equipment.setId(id);
        equipmentController.update(equipment);
        System.out.println("");

    }

    private void deleteEquipment() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        equipmentController.delete(id);
        System.out.println("");
    }

    private Equipment getEquipmentFromInput() {
        System.out.println("Type inventory_numbers:");
        Integer inventory_numbers = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type color:");
        String color = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type body_material:");
        String body_material = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type condition_of_equipment:");
        String condition_of_equipment = scanner.nextLine().replaceAll(" ", "");

        return new Equipment(inventory_numbers, color, body_material, condition_of_equipment);
    }

    private void getAllUser() throws SQLException {
        System.out.println("");
        userController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getUserById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        System.out.println("\n" + userController.findById(id));
        System.out.println("");
    }

    private void createUser() throws SQLException {
        System.out.println("");
        userController.create(getUserFromInput());
        System.out.println("");
    }

    private void updateUser() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        User user = getUserFromInput();
        user.setId(id);
        userController.update(user);
        System.out.println("");

    }

    private void deleteUser() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        userController.delete(id);
        System.out.println("");
    }

    private User getUserFromInput() {
        System.out.println("Type surname:");
        String surname = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type name:");
        String name = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type student_number:");
        String student_number = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type zip:");
        Integer zip = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));

        return new User(surname, name, student_number, zip);
    }

    private void getAllLaserCutter() throws SQLException {
        System.out.println("");
        laserCutterController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getLaserCutterById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        System.out.println("\n" + laserCutterController.findById(id));
        System.out.println("");
    }

    private void createLaserCutter() throws SQLException {
        System.out.println("");
        laserCutterController.create(getLaserCutterFromInput());
        System.out.println("");
    }

    private void updateLaserCutter() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        LaserCutter laserCutter = getLaserCutterFromInput();
        laserCutter.setId(id);
        laserCutterController.update(laserCutter);
        System.out.println("");

    }

    private void deleteLaserCutter() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        laserCutterController.delete(id);
        System.out.println("");
    }

    private LaserCutter getLaserCutterFromInput() {
        System.out.println("Type time_using:");
        String time_using = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type start_data:");
        String start_data = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type end_data:");
        String end_data = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type equipment_id:");
        Integer equipment_id = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));

        return new LaserCutter(time_using, start_data, end_data, equipment_id);
    }

    private void getAllEquipmentTransfer() throws SQLException {
        System.out.println("");
        equipmentTransferController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getEquipmentTransferById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        System.out.println("\n" + equipmentTransferController.findById(id));
        System.out.println("");
    }

    private void createEquipmentTransfer() throws SQLException {
        System.out.println("");
        equipmentTransferController.create(getEquipmentTransferFromInput());
        System.out.println("");
    }

    private void updateEquipmentTransfer() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        EquipmentTransfer equipmentTransfer = getEquipmentTransferFromInput();
        equipmentTransfer.setId(id);
        equipmentTransferController.update(equipmentTransfer);
        System.out.println("");

    }

    private void deleteEquipmentTransfer() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        equipmentTransferController.delete(id);
        System.out.println("");
    }

    private EquipmentTransfer getEquipmentTransferFromInput() {
        System.out.println("Type time:");
        String time = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type start_data:");
        String start_data = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type end_data:");
        String end_data = scanner.nextLine().replaceAll(" ", "");

        return new EquipmentTransfer(time, start_data, end_data);
    }

    private void getAllRepairsWorker() throws SQLException {
        System.out.println("");
        repairsWorkerController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getRepairsWorkerById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        System.out.println("\n" + repairsWorkerController.findById(id));
        System.out.println("");
    }

    private void createRepairsWorker() throws SQLException {
        System.out.println("");
        repairsWorkerController.create(getRepairsWorkerFromInput());
        System.out.println("");
    }

    private void updateRepairsWorker() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        RepairsWorker repairsWorker = getRepairsWorkerFromInput();
        repairsWorker.setId(id);
        repairsWorkerController.update(repairsWorker);
        System.out.println("");

    }

    private void deleteRepairsWorker() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        repairsWorkerController.delete(id);
        System.out.println("");
    }

    private RepairsWorker getRepairsWorkerFromInput() {
        System.out.println("Type name:");
        String name = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type surname:");
        String surname = scanner.nextLine().replaceAll(" ", "");

        return new RepairsWorker(name, surname);
    }

    private void getAllRepair() throws SQLException {
        System.out.println("");
        repairController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getRepairById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        System.out.println("\n" + repairController.findById(id));
        System.out.println("");
    }

    private void createRepair() throws SQLException {
        System.out.println("");
        repairController.create(getRepairFromInput());
        System.out.println("");
    }

    private void updateRepair() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        Repair repair = getRepairFromInput();
        repair.setId(id);
        repairController.update(repair);
        System.out.println("");

    }

    private void deleteRepair() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        repairController.delete(id);
        System.out.println("");
    }

    private Repair getRepairFromInput() {
        System.out.println("Type time:");
        String time = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type start_data:");
        String start_data = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type end_data:");
        String end_data = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type repairs_worker_id:");
        Integer repairs_worker_id = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type equipment_id:");
        Integer equipment_id = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type repairs_worker_id1:");
        Integer repairs_worker_id1 = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));

        return new Repair(time, start_data, end_data, repairs_worker_id, equipment_id, repairs_worker_id1);
    }

    private Integer readId(String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        input = input.replaceAll(" ", "");
        return Integer.parseInt(input);
    }

    public void show() throws SQLException {
        Menu.displayMenu();
        String input = scanner.nextLine();
        input = input.replaceAll(" ", "");

        while (!input.equals("QUIT")) {
            menu.get(input).print();
            input = scanner.nextLine();
            input = input.replaceAll("\\s", "");
        }
    }
}