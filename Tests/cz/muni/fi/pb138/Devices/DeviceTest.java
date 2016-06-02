/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.Devices;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Kristýna Leknerová
 * @version 2.6.2016
 */
public class DeviceTest {
    
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void createDevice() {
        Device computer = new Device.Builder(666L, DeviceType.COMPUTER, "address", 0).build();
        
        Long id = computer.getDid();
        assertEquals(id.longValue(), 666L);
    }
    
    @Test
    public void createDeviceNullDid() {
        exception.expect(IllegalArgumentException.class);
        Device computer = new Device.Builder(null, DeviceType.COMPUTER, "address", 0).build();
    }
    
    @Test
    public void createDeviceNullAddress() {
        exception.expect(IllegalArgumentException.class);
        Device computer = new Device.Builder(666L, DeviceType.COMPUTER, null, 0).build();
    }

    @Test
    public void testSetNumberOfPorts() {
        Device computer = new Device.Builder(666L, DeviceType.COMPUTER, "address", 0).build();
        assertEquals(computer.getArrayOfEthernetPorts().size(), 0);
        
        computer.setNumberOfPorts(10);
        assertEquals(computer.getNumberOfEthernetPorts(), 10);
        assertEquals(computer.getArrayOfEthernetPorts().size(), 10);
    }
    
    @Test
    public void testSetNumberOfPortsShrinking() {
        Device computer = new Device.Builder(666L, DeviceType.COMPUTER, "address", 8).build();
        assertEquals(computer.getArrayOfEthernetPorts().size(), 8);
        
        computer.setNumberOfPorts(5);
        assertEquals(computer.getNumberOfEthernetPorts(), 5);
        assertEquals(computer.getArrayOfEthernetPorts().size(), 5);
    }
    
    @Test
    public void testSetNumberOfPortsExpanding() {
        Device computer = new Device.Builder(666L, DeviceType.COMPUTER, "address", 2).build();
        assertEquals(computer.getArrayOfEthernetPorts().size(), 2);
        
        computer.setNumberOfPorts(42);
        assertEquals(computer.getNumberOfEthernetPorts(), 42);
        assertEquals(computer.getArrayOfEthernetPorts().size(), 42);
    }

    @Test
    public void testIsSwitchTrue12() {
        Device device = new Device.Builder(666L, DeviceType.SWITCH12, "address", 0).build();
        assertTrue(device.isSwitch());
    }
    
    @Test
    public void testIsSwitchTrue24() {
        Device device = new Device.Builder(666L, DeviceType.SWITCH24, "address", 0).build();
        assertTrue(device.isSwitch());
    }
    
    @Test
    public void testIsSwitchTrue48() {
        Device device = new Device.Builder(666L, DeviceType.SWITCH48, "address", 0).build();
        assertTrue(device.isSwitch());
    }
    
    @Test
    public void testIsSwitchFalse() {
        Device device = new Device.Builder(666L, DeviceType.COMPUTER, "address", 0).build();
        assertFalse(device.isSwitch());
    }

    @Test
    public void testEquals() {
        Device device1 = new Device.Builder(666L, DeviceType.COMPUTER, "address", 0).build();
        Device device2 = new Device.Builder(666L, DeviceType.COMPUTER, "address", 0).build();
        assertTrue(device1.equals(device2));
    }
    
    @Test
    public void testEqualsOnlyDid() {
        Device device1 = new Device.Builder(666L, DeviceType.COMPUTER, "address1", 0).build();
        Device device2 = new Device.Builder(666L, DeviceType.COMPUTER, "address2", 0).build();
        assertFalse(device1.equals(device2));
    }
    
    @Test
    public void testEqualsOnlyAddress() {
        Device device1 = new Device.Builder(666L, DeviceType.COMPUTER, "address", 0).build();
        Device device2 = new Device.Builder(999L, DeviceType.COMPUTER, "address", 0).build();
        assertFalse(device1.equals(device2));
    }
}