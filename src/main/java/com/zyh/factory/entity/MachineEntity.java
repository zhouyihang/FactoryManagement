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
    private Long machineId;
    @Column
    private String machineStatus;
    @Column
    private String machineName;
    @Column
    private String machineModel;
    @Column
    private Integer machineSpeed; //default 1.
    @Embedded
    private List<MachineWorkHourEntity> machineWorkhour;
	public Long getMachineId() {
		return machineId;
	}
	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}
	public String getMachineStatus() {
		return machineStatus;
	}
	public void setMachineStatus(String machineStatus) {
		this.machineStatus = machineStatus;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getMachineModel() {
		return machineModel;
	}
	public void setMachineModel(String machineModel) {
		this.machineModel = machineModel;
	}
	public Integer getMachineSpeed() {
		return machineSpeed;
	}
	public void setMachineSpeed(Integer machineSpeed) {
		this.machineSpeed = machineSpeed;
	}
	public List<MachineWorkHourEntity> getMachineWorkhour() {
		return machineWorkhour;
	}
	public void setMachineWorkhour(List<MachineWorkHourEntity> machineWorkhour) {
		this.machineWorkhour = machineWorkhour;
	}
    
    
}
