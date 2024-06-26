package com.smartHomeManagement.acme.inventory.domain.model.aggregates;


import com.smartHomeManagement.acme.inventory.domain.model.commands.CreateDeviceCommand;
import com.smartHomeManagement.acme.shared.domain.model.entities.DeviceTypes;
import com.smartHomeManagement.acme.inventory.domain.model.valueobjects.DeviceStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

/**
 *  Device aggregate root
 *  <p>
 *      This class represents the device aggregate root.
 *      It contains the device attributes and the device type.
 *  </p>
 * @author  U202212721 Mathias Jave Diaz
 * @version 1.0
 */
@Getter
@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Column(nullable = false, length = 30)
    @Size(max= 30)
    private String serialNumber;

    @Setter
    @Column(nullable = false, length = 50)
    @Size(max= 50)
    private String model;


    @Setter
    @ManyToOne
    @JoinColumn(name = "device_type_id", nullable = false)
    private DeviceTypes deviceTypes;

    @CreatedDate
    private Date installationDate ;

    @Setter
    @Column(nullable = false, length = 20)
    @Size(max= 20)
    @Enumerated(EnumType.STRING)
    private DeviceStatus status;

    public Device() {
        /**
         * Default Device constructor
         * <p>
         *     This constructor is used to create a new Device object.
         *     Is required for Spring Data JPA.
         * </p>
         * @autor U202212721 Mathias Jave Diaz
         */
    }


    public Device(CreateDeviceCommand command, DeviceTypes deviceTypes){
        /**
         * Device constructor
         * <p>
         *     This constructor is used to create a new Device object.
         *     It receives a CreateDeviceCommand object as parameter.
         * </p>
         * @param command CreateDeviceCommand object
         * @autor U202212721 Mathias Jave Diaz
         */
        this.serialNumber = command.serialNumber();
        this.model = command.model();
        this.status = command.status();
        this.deviceTypes = deviceTypes;
        this.installationDate = new Date();

    }

}
