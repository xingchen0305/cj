import {Injectable} from "@angular/core";
import {HttpInterceptor} from "../auth/HttpInterceptor";
import {EQUIPMENT_URI} from "../backen-const";
import {Observable} from "rxjs/Observable";
/**
 * Created by Administrator on 2017/6/17 0017.
 */


@Injectable()
export class WarehouseService{
  warehouseUrl: string = EQUIPMENT_URI + '/baseWarehouse';
  constructor(private http: HttpInterceptor) { }

  /**
   *  获取仓库列表
   * @returns {Observable<Response>}
   */
  getWareHouses(page:number = 1, size:number=10): Observable<any> {
    return this.http.get(this.warehouseUrl+'/page?page='+page+'&size='+size);
  }

  /**
   *  根据id 查看仓库信息
   * @param index
   * @returns {Observable<Response>}
   */
  getWareHouseById(index): Observable<any>{
    return this.http.get(this.warehouseUrl+ "/findById/?id=" + index)
  }

  /**
   *  修改
   * @param wareHouseData
   * @returns {Observable<Response>}
   */
  editWareHouse(wareHouseData){
    return this.http.post(this.warehouseUrl +"/saveOrUpdate", wareHouseData);
  }


}
