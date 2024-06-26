package com.smartHomeManagement.acme.inventory.domain.model.entities;

import com.smartHomeManagement.acme.inventory.domain.model.valueobjects.DeviceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;

/**
 * DeviceTypes entity
 * <p>
 *     - This class represents the DeviceTypes entity.
 *     - It contains the device type.
 *   </p>
 */
@Entity
@Getter
public class DeviceTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 20)
    @Size(max= 20)
    @Enumerated(EnumType.STRING)
    private DeviceType type;

    public DeviceTypes() {
        /**
         * Default DeviceTypes constructor
         * <p>
         *     This constructor is used to create a new DeviceTypes object.
         *     Is required for Spring Data JPA.
         * </p>
         * @autor U202212721 Mathias Jave Diaz
         */
    }

    public DeviceTypes(DeviceType type) {
        /**
         * DeviceTypes constructor
         * <p>
         *     This constructor is used to create a new DeviceTypes object.
         *     Is required for Spring Data JPA.
         * </p>
         * @autor U202212721 Mathias Jave Diaz
         */
        this.type = type;
    }

}
