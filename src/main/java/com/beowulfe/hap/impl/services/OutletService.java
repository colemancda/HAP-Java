package com.beowulfe.hap.impl.services;

import com.beowulfe.hap.accessories.Outlet;
import com.beowulfe.hap.impl.characteristics.common.Name;
import com.beowulfe.hap.impl.characteristics.common.PowerStateCharacteristic;
import com.beowulfe.hap.impl.characteristics.outlet.OutletInUseCharacteristic;

public class OutletService extends AbstractServiceImpl {

	public OutletService(Outlet outlet) {
		super("00000047-0000-1000-8000-0026BB765291");
		addCharacteristic(new Name(outlet));
		addCharacteristic(new PowerStateCharacteristic(
				() -> outlet.getPowerState(),
				v -> outlet.setPowerState(v),
				c -> outlet.subscribePowerState(c),
				() -> outlet.unsubscribePowerState()
			));
		addCharacteristic(new OutletInUseCharacteristic(outlet));
	}

}
