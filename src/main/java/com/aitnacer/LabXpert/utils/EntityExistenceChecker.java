package com.aitnacer.LabXpert.utils;

public interface EntityExistenceChecker<T> {
    T checkExistenceByIdOrThrow(long id);

}
