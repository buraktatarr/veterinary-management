package com.veterinary_management.core.dto.requests;

import lombok.Builder;

@Builder
public record CustomerCreateRequest(
		String name,
		String phone,
		String mail,
		String address,
		String city
) {
}
