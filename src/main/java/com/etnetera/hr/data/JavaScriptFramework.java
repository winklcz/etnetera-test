package com.etnetera.hr.data;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple data entity describing basic properties of every JavaScript framework.
 * 
 * @author Etnetera
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JavaScriptFramework {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JavaScriptFramework_generator")
	@SequenceGenerator(name="JavaScriptFramework_generator", sequenceName = "JavaScriptFramework_seq", initialValue = 1000)
	private Long id;

	@Column(nullable = false, length = 30, unique = true)
	private String name;

	@ToString.Exclude
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "jsf_id", nullable = false, updatable = false)
	private List<JavaScriptFrameworkVersion> versions;

	@Column
	private Date deprecationDate;
}
