package com.etnetera.hr.data;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JavaScriptFrameworkVersion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JavaScriptFrameworkVersion_generator")
	@SequenceGenerator(name="JavaScriptFrameworkVersion_generator", sequenceName = "JavaScriptFrameworkVersion_seq", initialValue = 1000)
	private Long id;

	@Column(nullable = false)
	private String number;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@JoinColumn(name = "jsf_id", updatable = false, insertable = false)
	private JavaScriptFramework jsf;
}
