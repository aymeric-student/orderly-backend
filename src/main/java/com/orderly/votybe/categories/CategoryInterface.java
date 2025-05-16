package com.orderly.votybe.categories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryInterface extends JpaRepository<Category, UUID> {
}
