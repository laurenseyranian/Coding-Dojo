package com.codingdojo.dojooverflow.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojooverflow.models.Tag;

public interface TagRepository extends CrudRepository <Tag, Long>{
	Optional<Tag> findBySubject(String string);
}
