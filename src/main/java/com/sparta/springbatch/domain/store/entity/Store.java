package com.sparta.springbatch.domain.store.entity;

import com.sparta.springbatch.domain.user.entity.User;
import com.sparta.springbatch.global.entity.Deleted;
import com.sparta.springbatch.global.entity.TimeStamped;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store extends TimeStamped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String storeName;

	private String info;

	private boolean isApproved;

	@Enumerated(EnumType.STRING)
	private Deleted deleted;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
