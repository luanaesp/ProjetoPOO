package io.github.mariazevedo88.travelsapi.factory;

import io.github.mariazevedo88.travelsapi.model.Travel;

/**
 * Interface that provides method for manipulate an object Travel.
 * 
 */
public interface TravelFactory {

	Travel createTravel (String type);
}
