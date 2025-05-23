// this should work it has all the methods for USB

import java.util.HashMap;

public class patricktest {
    // private so it is encapsulated within the class, USB is an instance of the class
    private usbInfo usb;
    // declares and initializes a static, private HashMap called vendorMap that maps String keys to String values.
    private static HashMap<String, String> vendorMap = new HashMap<>();
    private static HashMap<String, String> productMap = new HashMap<>();



    public patricktest() {

        //new usbInfo() creates a new instance of the usbInfo class
        // this is used to make clear it is an instance variable
        this.usb = new usbInfo();
        initializeMaps();
    }

    // Reads data on USB so the following methods can have data
    public void readUSB() {
        usb.read();
    }

    // Bus Count
    public int getBusCount() {
        return usb.busCount();
    }
    // Device Count
    public int getDeviceCount(int bus) {
        return usb.deviceCount(bus);
    }
    // Vendor ID
    public int getVendorID(int bus, int device) {
        return usb.vendorID(bus, device);
    }
    // Product ID
    public int getProductID(int bus, int device) {
        return usb.productID(bus, device);
    }

    // Get vendor name from ID
    public String getVendorName(int vendorId) {
        // Convert vendorId from a int to hexadecimal
        String hexVendorId = String.format("0x%04X", vendorId);
        // if vendor map contains the hex return the corresponding vendor name else "Unknown company"
        if (vendorMap.containsKey(hexVendorId)) {
            return vendorMap.get(hexVendorId);
        } else {
            return "Unknown company";
        }
    }
    // Get product description from ID
    public String getProductDescription(int productId) {

        // Convert productrId from a int to hexadecimal
        String hexProductId = String.format("0x%04X", productId);

        // if product map contains the hex return the corresponding product name else "Unknown company"
        if (productMap.containsKey(hexProductId)) {
            return productMap.get(hexProductId);
        } else {
            return "Unknown product";
        }
    }

    // Get all USB info as 2D array
    public String[][] getUSBInfoAs2DArray() {
        readUSB(); // Refresh USB data

        // Calculate total number of devices
        int totalDevices = 0;
        for (int i = 1; i <= getBusCount(); i++) {

            // Adds the device count for the current bus to totalDevices, accumulating the count across all buses.
            totalDevices += getDeviceCount(i);
        }

        // Create and give the array data
        String[][] usbArray = new String[totalDevices][6];
        // starting position for rows in an array
        int rowIndex = 0;

        for (int bus = 1; bus <= getBusCount(); bus++) {
            for (int device = 1; device <= getDeviceCount(bus); device++) {
                int vendorId = getVendorID(bus, device);
                int productId = getProductID(bus, device);
                // creates a new 1D array
                // The variable rowIndex in usbArray[rowIndex] tells the program which row in usbArray to put the information for each device.
                // Each time a new device’s details are added, rowIndex points to the next row in usbArray, so every device has its own row for its data.
                usbArray[rowIndex] = new String[]{
                        // convert int to string
                        String.valueOf(bus),                          // Bus number
                        String.valueOf(device),                       // Device number
                        // formats into hexademical
                        String.format("0x%04X", vendorId),           // Vendor ID in hex
                        // getVendorName takes in vendorId and returns a string with the vendor's name.
                        getVendorName(vendorId),                     // Vendor name
                        String.format("0x%04X", productId),          // Product ID in hex
                        getProductDescription(productId)             // Product description
                };
                // After adding the current device’s information to usbArray, rowIndex is incremented to move to the next row for the next device.
                rowIndex++;
            }
        }
        return usbArray;
    }

    private void initializeMaps() {

        // Vendor ID's HashMap

        vendorMap.put("0x8086", "Intel Corporation");
        vendorMap.put("0x10DE", "NVIDIA Corporation");
        vendorMap.put("0x1414", "Microsoft Corporation");
        vendorMap.put("0x106B", "Apple Corporation");
        vendorMap.put("0x046D", "Logitech Corporation");
        vendorMap.put("0x05AC", "Apple, Inc.");
        vendorMap.put("0x04B3", "IBM Corporation");
        vendorMap.put("0x17EF", "Lenovo Group Limited");
        vendorMap.put("0x18D1", "Google Inc.");
        vendorMap.put("0x12D1", "Huawei Technologies Co., Ltd.");
        vendorMap.put("0x1D6B", "Linux Foundation");
        vendorMap.put("0x1A86", "QinHeng Electronics");
        vendorMap.put("0x05E3", "Genesys Logic, Inc.");
        vendorMap.put("0x045E", "Microsoft Corporation");
        vendorMap.put("0x0BDA", "Realtek Semiconductor Corp.");
        vendorMap.put("0x1C4F", "SiGma Micro");
        vendorMap.put("0x04E8", "Samsung Electronics Co., Ltd.");
        vendorMap.put("0x0A5C", "Broadcom Corp.");
        vendorMap.put("0x0461", "Primax Electronics, Ltd.");
        vendorMap.put("0x04A9", "Canon Inc.");
        vendorMap.put("0x093A", "Pixart Imaging, Inc.");
        vendorMap.put("0x13FE", "Kingston Technology Company");
        vendorMap.put("0x0CF3", "Qualcomm Atheros Communications");
        vendorMap.put("0x22B8", "Motorola PCS");
        vendorMap.put("0x0403", "Future Technology Devices International, Ltd.");
        vendorMap.put("0x0D28", "ARM, Ltd.");
        vendorMap.put("0x0951", "Kingston Technology Company, Inc.");
        vendorMap.put("0x0557", "ATEN International Co., Ltd.");
        vendorMap.put("0x04BB", "I-O Data Device, Inc.");
        vendorMap.put("0x054C", "Sony Corporation");
        vendorMap.put("0x13D3", "IMC Networks");
        vendorMap.put("0x04D8", "Microchip Technology, Inc.");
        vendorMap.put("0x0451", "Texas Instruments, Inc.");
        vendorMap.put("0x12BA", "Aptiv Services US, LLC");
        vendorMap.put("0x046A", "Cherry GmbH");
        vendorMap.put("0x07B4", "ONTOTech LLC");
        vendorMap.put("0x08BB", "Texas Instruments Japan");
        vendorMap.put("0x0572", "Conexant Systems, Inc.");
        vendorMap.put("0x17CC", "Core Logic");
        vendorMap.put("0x04B4", "Cypress Semiconductor Corp.");
        vendorMap.put("0x0B05", "ASUSTek Computer Inc.");
        vendorMap.put("0x04DA", "Panasonic (Matsushita)");
        vendorMap.put("0x0731", "Sun Microsystems, Inc.");
        vendorMap.put("0x1234", "SigmaTel, Inc.");
        vendorMap.put("0x05A9", "OmniVision Technologies, Inc.");
        vendorMap.put("0x06CB", "Synaptics, Inc.");
        vendorMap.put("0x1B1C", "Corsair Memory, Inc.");
        vendorMap.put("0x0002", "Freescale Semiconductor, Inc.");
        vendorMap.put("0x0001", "Mercury Computer Systems");
        vendorMap.put("0x0781", "SanDisk Corporation, Inc.");
        vendorMap.put("0x80EE", "Samsung Electronics");

        // Product ID's HashMap

        productMap.put("0x1234", "USB 3.0 Controller");
        productMap.put("0x5678", "Gaming Mouse");
        productMap.put("0x8765", "Wireless Adapter");
        productMap.put("0x4321", "Bluetooth Module");
        productMap.put("0x1001", "USB 2.0 Hub");
        productMap.put("0x2002", "Webcam HD 720p");
        productMap.put("0x3003", "USB-C to HDMI Adapter");
        productMap.put("0x4004", "Ethernet Adapter");
        productMap.put("0x5005", "External Hard Drive");
        productMap.put("0x6006", "USB Flash Drive 32GB");
        productMap.put("0x7007", "Wireless Keyboard Receiver");
        productMap.put("0x8008", "External DVD Drive");
        productMap.put("0x9009", "Fingerprint Reader");
        productMap.put("0xA00A", "Graphics Tablet");
        productMap.put("0xB00B", "Portable Charger");
        productMap.put("0xC00C", "Thermal Printer");
        productMap.put("0xD00D", "Smart Card Reader");
        productMap.put("0xE00E", "Sound Card");
        productMap.put("0xF00F", "Wireless Display Adapter");
        productMap.put("0x1111", "USB Hub 4-Port");
        productMap.put("0x2222", "Digital Audio Interface");
        productMap.put("0x3333", "MIDI Controller");
        productMap.put("0x4444", "USB 3.1 Type-C Adapter");
        productMap.put("0x5555", "VR Headset Interface");
        productMap.put("0x6666", "Touchscreen Controller");
        productMap.put("0x7777", "USB Wi-Fi Dongle");
        productMap.put("0x8888", "LED Light Strip Controller");
        productMap.put("0x9999", "Portable Projector");
        productMap.put("0xAAAA", "USB to Serial Adapter");
        productMap.put("0xBBBB", "3D Printer Interface");
        productMap.put("0xCCCC", "Temperature Sensor");
        productMap.put("0xDDDD", "Motor Controller for Robotics");
        productMap.put("0xEEEE", "Camera Interface Module");
        productMap.put("0xFFFF", "Gaming Controller Adapter");
        productMap.put("0x0002", "Z-Wave Wave 1 device");
        productMap.put("0x0001", "Virtual Box Placeholder");
        productMap.put("0x0021", "Host Controller");
        productMap.put("0x0002", "Virtual Box Placeholder");
        productMap.put("0x557D", "Sandisk USB Components");

    }
}