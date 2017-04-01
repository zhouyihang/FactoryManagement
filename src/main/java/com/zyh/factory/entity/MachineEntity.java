package com.zyh.factory.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "machine")
public class MachineEntity {

    @Id
    @GeneratedValue
    private String machineId;
    @Column
    private String machineName;
    @Column
    private String machineModel;
    @Column
    private int machineSpeed; //default 1.
    @Embedded
    private List<MachineWorkHourEntity> machineWorkhour;
}
