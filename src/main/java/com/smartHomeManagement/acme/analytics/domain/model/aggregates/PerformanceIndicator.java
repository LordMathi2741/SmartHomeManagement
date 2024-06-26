package com.smartHomeManagement.acme.analytics.domain.model.aggregates;

import com.smartHomeManagement.acme.analytics.domain.model.commands.CreatePerformanceIndicatorCommand;
import com.smartHomeManagement.acme.inventory.domain.model.aggregates.Device;
import com.smartHomeManagement.acme.shared.domain.model.valueobjects.DeviceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 *  PerformanceIndicators aggregate root
 *  <p>
 *     - This class represents the PerformanceIndicators aggregate root.
 *     - It contains the attributes of the PerformanceIndicators entity.
 *  </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
@Entity
@Getter
public class PerformanceIndicator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 40)
    @Size(max = 40)
    private String name;

    @Column(nullable = false, length = 200)
    @Size(max = 200)
    private String description;

    @Column(nullable = false)
    private Double maxValue;

    @Column(nullable = false)
    private Double minValue;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

    @OneToMany
    @JoinColumn(name = "device_id", nullable = false)
    private ArrayList<Device> devices;

    public PerformanceIndicator(){
        this.devices = new ArrayList<>();
    }

    public PerformanceIndicator(CreatePerformanceIndicatorCommand command, ArrayList<Device> devices){
        this.name = command.name();
        this.description = command.description();
        this.maxValue = command.maxValue();
        this.minValue = command.minValue();
        this.deviceType = command.deviceType();
        this.devices = devices;
    }


}
