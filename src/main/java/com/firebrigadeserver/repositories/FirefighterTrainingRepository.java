package com.firebrigadeserver.repositories;

import com.firebrigadeserver.entity.Firefighter;
import com.firebrigadeserver.entity.FirefighterTraining;

public interface FirefighterTrainingRepository {

    FirefighterTraining findByFirefighter(Firefighter firefighter);
}
