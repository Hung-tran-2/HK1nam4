#include"Header.h"
using namespace std;
 

//int main() {//ôn tập mảng cấu trúc và giải thuật tìm kiếm
//	int a[MAX], n, x;
//	cout << "nhap so phan tu cua mang ";
//	cin >> n;
//	nhapMang(a, n);
//	sapXep(a, n);
//	xuatMang(a, n);
//	cout << "\nnhap so can tim kiem ";
//	cin >> x;
//	cout << timKiemtuantu(a, n, x) << endl;
//	cout << timKiemNhiPhan(a, n, x);
//	return 0;
	//system("pause");
	//char str[30];
	////cout << "nhap vao mot chuoi ";
	//cin.getline(str, 30);
	//cout << "chuoi vua nhap la [" << str << "]" << endl;
	//chuanHoa_chuoi(str);
	//cout << "chuoi sau khi chuan hoa [" << str << "]" << endl;
	//chuyen_ChuHoa(str);
	//cout << "chuoi sau khi chuyen chu hoa [" << str<<"] " << endl;
	//system("pause");
//}

//void main() {//phần mảng 1 chiều và truyền tham biến
//	int  n;
//	int b[KTM];
//	nhapPhanTuCuaMang(n);
//	nhapMang(b, n);
//	xuatMang(b, n);
//	//dem_SoHoanThien(b, n);
//	//cout<<"\n"<<tong_PTD(b, n);
//	//cout << "\n" << tim_max(b, n)<<endl;
//	//demsNt12(b, n);
//	cout<<"\n"<<boiCua3(b, n) << endl;
//	xuat_SoChan(b, n);
//	xuat_SoLe(b, n);
//	cout<<tong_BoiS7(b, n)<<endl;
//	cout<<tong_SoNguyenTo(b, n)<<endl;
//	xuat_PTChanNhoHon20(b, n); 
//	xuat_SoChinhPhuongVTLe(b, n);
//
//	system("pause");
//}

//int main() {//chương hàm và truyen tham chiếu
//	/*int n;//bai tap chuong 5 viet ham va truyen tham tri
//	do {
//		cout << "nhap so nguyen duong: ";
//		cin >> n;
//	} while (n<=0);
//	cout << "liet ke so nguyen duong vua nhap la ";
//	duyetXuoi_lietKSN(n);
//	cout << "\nnguoc lai ";
//	duyetNguoc_lietKSN(n);*/
//	/*int a, b;
//	do
//	{
//		cout << "nhap hai so nguyen a va b ";
//		cin >> a >> b;
//	} while (a<=0||b<=0);
//	cout<<"so vua cap nhat la ";
//	capNhat(a, b);*/
//	//int h;
//	//cout << "nhap chieu cao h";
//	//cin >> h;
//	//in_TGS(h);
//	/*int n = 0;
//	cout << "nhap so nguyen duong ";
//	nhap_SN(n);
//	cout << "gia tri cua bieu thuc la ";
//	cout<<tinh_SN(n);*/
//
//	//int n;
//	//nhapSoNguyenDuong(n);
//	//int t = kt_SoNguyenTo(n);
//	//if (t == 0)
//	//	cout << "khong la so nguyen to";
//	//else
//	//cout << "la so nguyen to";
//	//int n;
//	//cout << "nhap ban kinh r ";
//	//nhap_SN(n);
//	////tinh_DTvaCV(n);
//	//int i =kt_1SCP(n);
//	//if (i == 1)
//	//	cout << "la so chinh puong";
//	//else
//	//	cout << "k la so chinh puong";
//	//int a;//kiem tra chan le n<5 || n>0
//	//nhapSND(a);
//	//dem_SCvaSl(a);
//
//	int n;
//	nhapSND(n);
//	int i = dem_SNT(n);
//	cout <<"so luong so nguyen to la "<< i;
//	return 0;
//} 

////cau 5
//int kTSCP(int n) {
//	int ketqua = sqrt(n);
//	if (ketqua * ketqua == n)
//		return n;
//	return false;
//}
////cau 2
//int kTSA(int n){
//	if (n < 0) {
//		return n;
//	}
//	return 0;
// }
//int main() {
//	/*string STRstring("");
//	string STRstring1("Kasd");
//	string STRstring2("asdfa");
//	string STRstring3="gan truc tiep";
//	string STRstring4= STRstring2;
//	string STRstring7 = "88";
//
//	cout << STRstring << endl;
//	cout << STRstring1 << endl;
//	cout << STRstring2 << endl;
//	cout << STRstring3 << endl;
//	cout << STRstring4 << endl;
//	cout << STRstring7 << endl;
//	getline(cin, STRstring);
//	cout << STRstring << endl;*/
//	//int dem = 0;
//	//int a[6] = {-7, 2, -3, 4 , 4, 16};
//	//for (int i = 0; i < 6; i++)
//	//{	
//	//	if (i % 2 == 0 && a[i] % 2 == 0)
//	//		dem++;
//	//	if (kTSA(a[i]) != 0) {
//	//		cout << a[i] << endl;
//	//	}
//	//	if (kTSCP(a[i]) != 0)
//	//		cout << a[i] << endl;
//	//}
//	//cout << dem;
//
//	////cau 1 khai bao 2 bien son nguyen va 1 bien so thuc va in ra mang hinh
//	//int a = 10, b = 15;
//	//float c = 12.5;
//	//cout << a << b << c<<endl;
//
//	////cau 2 nhac nguoi dung nha ten va in ra mang hinh
//	//char hoten[20];
//	//cout << "Nhap Ten ban" << endl;
//	//cin >> hoten;
//	//cout << hoten;
//	
//	////cau 3 nhap vao 3 so nguyen sap sep tang dan va dam dan
//	//int m, max;
//	//int n;
//	//int l;
//	//cout << "\nNhap vao 3 so nguyen";
//	//nhap3SN(m, n, l);
//	//sapxep(m, n, l);
//
//	////cau4 in ra 1 so nguyen, thuc, ki tu da duoc dinh nghia tu truoc
//	//int a;
//	//float b;
//	//char c;
//	//cout << "nhap 3 so nguyen, thuc, ki tu";
//	//nhap3NTK(a, b, c);
//	//cout << "in ra 3 so nguyen, thuc, ki tu";
//	//xuat3NTK(a, b, c);
//	
//	////bai tap ve toan tu
//	////cau 1 viet CT de tim tong, hieu, tich, thuong cua hai so nguyen
//	//int a, b;
//	//cout << "\nNhap hai so nguyen ";
//	//nhap2SN(a, b);
//	//cout << "tim tong, tong, hieu, tich, thuong cua hai so nguyen vua nhap"<<endl;
//	//tinhTHTT(a, b);
//
//	////cau 2 tim tong va trung binh hai son nguyen vua nhap
//	//int a, b;
//	//cout << "\nNhap hai so nguyen ";
//	//nhap2SN(a, b);
//	//cout << "tong va trung binh hai so nguyen vua nhap" << endl;
//	//tongVTB(a, b);
//
//	////cau 3 tim van toc cuoi cung biet van toc dau , gia toc, thoi gian (v = u + a*t)
//	//int a, b, c;
//	//cout << "nhap van toc dau, gia toc, thoi gian cho bieu thuc"<<endl; 
//	//nhapVT(a, b, c);
//	//tinhVTC(a, b, c);
//
//	/*int i = -1, sum = 0;
//	while (i < 100) {
//		i += 2;
//		if (i % 3 == 0)
//			continue;
//		sum += i;
//	}*/
//
//	//char ten[20];
//	//int tien = 0, soluong, dongia;
//	//cout << "nhap ten san pham : " ;
//	//cin >> ten;
//	//cout << "nhap so luong va don gia : ";
//	//cin >> soluong >> dongia;
//	//tien = soluong * dongia;
//	//cout << "tien = "<<tien<<endl;
//	//cout << "thue VAT = " << tien * 0.1;
//
//	/*int nut,a=7, b, c, d;
//	cout << "nhap vao 4 so xe cua ba"<<endl;
//	cin >> a >> b >> c >> d;
//	nut = (a + b + c + d) % 10;
//	cout << "so nuc la " << nut;
//	nut =  !a;
//	cout << nut;*/
//
//	return 0;
//} 
//int main() {
//	/*int t, l, h, tong = 0;//nhap toan ly hoa KT ket qua
//	cout << "nhap diem toan, ly, hoa ";
//	cin >> t >> l >> h;
//	tong = t + l + h;
//	if (tong >= 15 && t >= 4 && l >= 4 && h >= 4) {
//		cout << "dau" << endl;
//		if (t>=5 && l>=5 && h >= 5) {
//			cout << "hoc deu cac mon" << endl;
//		}
//		else
//			cout << "hoc chua deu cac mon" << endl;
//	}
//	else
//		cout << "Thi hong";*/
//	//int  a, b;
//	//cout << "nhap vao hai so nguyen a, b va gian pt ax+b=0 ";
//	//cin >> a >> b;
//	///*if (b > 0)
//	//	cout << a << "*x+" << b;
//	//else
//	//	cout << a << "*x" << b;*/
//	//if (a == 0 && b == 0)
//	//	cout << "PT vo so nghiem";
//	//else if (a == 0 && b != 0)
//	//	cout << "PT vo nghiem";
//	//else
//	//	cout << "PT co nghiem duy nhat la " << -b / a;
//
//	/*int a, b, c, DT;
//	cout << "nhap he so a, b, c va gia PT ax^2+bx+c=0 ";
//	cin >> a >> b >> c;
//	DT = pow(b, 2) - 4 * a * c;
//	if (DT < 0)
//		cout << "phuong trinh vo nghiem DT < 0";
//	else if (DT == 0)
//		cout << "phuong trinh co mot nghie kep" << -b / 2 * a;
//	else
//		cout << "phuong trinh co hai nghiem x1 = " << (-b + sqrt(DT)) / (2 * a) << " x2 = " << (-b - sqrt(DT)) / (2 * a);*/
//
//	/*cout << "nhap so nguyen hai chu so ";
//	int n, a, b;
//	cin >> n;
//	a = n / 10;
//	b = n % 10;
//	if (n < 0 || n > 99)
//		cout << "nhap sai vui long nhap lai";
//	else
//		cout << "tong so nguyen cua hai chu so vua nhap = " << a + b;*/  
//
//	/*int h, p, s;
//	cout << "nhap gio, phut, giay ";
//	cin >> h >> p >> s;
//	if ((h<0) || (p<0) || (s<0) || (h>24) || (p>60) || (s>60))
//		cout << "nhap sai gio vui long nhap lai";
//	else {
//		h = 3600 * s;
//		p = 60 * s;
//		cout << "ket qua doi sang s la" << h + p + s;
//	}*/
//
//	/*int a, b, c, d;
//	cout << "nhap 4 so nguyen";
//	cin >> a >> b >> c >> d;
//	cout << "trung binh cong 4 so" << (a + b + c + d) / 4;*/
//
//	/*char hoten[20];
//	int dtb = 0, dToan, dVan, lamT;
//	cout << "nhap ho ten, diem toan, diem van ";
//	cin.getline(hoten,20);
//	cin >> dToan >> dVan;
//	dtb = (dToan * 2 + dVan) / 3;
//	lamT = (dToan * 2 + dVan) % 3;
//
//	if (lamT % 10 >= 5)
//		dtb += 1;
//	cout << "*******************************************************************"<<endl;
//	cout << "Ho Ten : " << hoten<<endl;
//	cout << "Diem toan : " << dToan << endl;
//	cout << "Diem van : " << dVan << endl;
//	cout << "Diem TB : " << dtb << endl;
//	cout << "Xep loai : ";
//	if (dtb >= 9)
//		cout << "xep loai Xuat sac";
//	else if (dtb >= 8)
//		cout << "xep loai gioi";
//	else if (dtb >= 6.5)
//		cout << "xep loai kha";
//	else if (dtb >= 5)
//		cout << "xep loai tb";
//	else
//		cout << "rot";
//	cout << "\n*******************************************************************";*/
//
//	/*int n;
//	cout << "nhap mot so nguyen ";
//	cin >>n ;
//	if (n % 3 == 0 && n % 5 == 0)
//		cout << "boi so cua 3 va 5 la " << n;
//	else
//		cout << "so vua nhap khong la boi so cua 3 va 5 nhap lai";*/
//
//	/*int n, thanhT;
//	cout << "nhap so KM ";
//	cin >> n;
//	if (n == 1) {
//		thanhT = n * 15000;
//		cout << "thanh tien = " << thanhT;
//	}
//	else if (n <= 30) {
//		n--;
//		thanhT = 15000 + n * 16500;
//		cout << "thanh tien = " << thanhT;
//	}
//	else {
//		n = n - 30;
//		thanhT = 15000 + 29 * 16500 + n * 16000;
//		cout << "thanh tien = " << thanhT;
//	}*/
//	
//	/*int a, b, c;
//	cout << "nhap so nguyen ";
//	cin >> a>> b>> c;
//	if (a > 0 && b > 0 && c > 0) {
//		if (a + b > c || b + c > a || a + c > b) {
//			cout << "ba so vua nhap la canh tam giac " << endl;
//			if (a == b && b == c && a == c)
//				cout << "la tam giac deu";
//			else if (a == b || b == c || a == c)
//				cout << "la tam giac can";
//			else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a)
//				cout << "la tam giac vuong";
//			else
//				cout << "la tam giac binh thuong";
//		}
//		else
//			cout << "ba so vua nhap khong la canh cua tam giac ";
//	}
//	else
//		cout << "canh cua tam giac khong am ";*/
//
//	/*int n, tong = 0; 
//	cout << "nhap so nguyen n ";
//	cin >> n;
//	if (n < 2)
//		cout << "khong la so chinh phuong";
//	else {
//		tong = sqrt(n);
//		if (tong * tong == n)
//			cout << "la so chinh phuong";
//		else
//			cout << "khong la so chinh phung";
//	}*/
//
//	//int n, i, sum;
//	//cout << "nhap mot so nguyen n: ";
//	//cin >> n;
//	//if (n > 0) {
//	//	sum = 0;
//	//	for (i = 1; i <= n; i++)
//	//	{
//	//		sum += i;
//	//	}
//	//	cout << "tong can tinh la " << sum << endl;
//	//}
//	//else
//	//	cout << "so vua nhap k duong";
//	
//	/*int n;
//	cout << "nhap mot so nguyen ";
//	cin >> n;
//	while (n < 2) {
//		cout << "nhap so nguyen >= 2 nhap lai ";
//		cin >> n;
//	}
//	int i, sum = 0;
//	for(i = 1;i < n; i++)
//		if (n % i == 0)
//			sum += i;
//		if (sum == n)
//			cout << n << " la so hoan thien";
//		else
//			cout << n << " khong la so hoan thien";*/
//	
//	/*int i, n, s = 0;
//	cin >> n;
//	for (i = 1; i <= n; i++) {
//		s = n*(n+i);
//		cout << "so lan lap " << i<<endl;
//		cout<<"tong s sau khi lap "<<s<<endl;
//	}cout << "tong s = " << s;*/
//
//	/*int n,sum=0;
//	cout << "nhap so nguyen n ";
//	cin >> n;
//	while (n != -999)
//	{
//		if (n % 3 == 0 && n % 7 == 0) {
//			cout << "so chi het cho 3 va 7 la " << n << endl;
//			sum += n;
//		}
//		else
//			cout << "so khong chia het cho 3 va 7 nhap lai "<<endl;
//		cin >> n;
//	}
//	cout << "tong cac so chia het cho 3 va 7 la " << sum;*/
//	
//	/*int n;
//	float sum =0;
//	cout << "nhap mot so nguyen duong ";
//	cin >> n;
//	if (n > 0) {
//		for (int i = 1; i <= n; i++) {
//			sum += 1.0 / i;
//		}
//		cout << "gia tri cua bieu thuc la : " << sum;
//	}
//	else
//		cout << "vui long nhap mot so nguyen duong ";*/
//
//	/*int n;
//	float sum =0;
//	cout << "nhap mot so nguyen duong ";
//	cin >> n;
//	if (n > 0) {
//		for (int i = 1; i <= n; i++) {
//			sum += i / (i+1.0);
//		}
//		cout << "gia tri cua bieu thuc la : " << sum;
//	}
//	else
//		cout << "vui long nhap mot so nguyen duong ";*/
//	
//	/*int n;
//	cout << "nhap mot so nguyen n ";
//	cin >> n;
//	if (n > 0) {
//		for (int i = 1; i <= n; i++) {
//			if (i % 2 == 0 || i % 5 == 0) {
//				cout << "so chia he cho 2 va 5 la " << i << " "<<endl;
//			}
//		}
//	}
//	else
//		cout << "vui long nhap mot so nguyen duong";*/
//
//	/*int n,sum=0;
//	cout << "nhap mot so nguyen n ";
//	cin >> n;
//	if (n > 0) {
//		for (int i = 1; i <= n; i++) {
//			if (n % i == 0) {
//				cout << "cac uoc cua " << n << " la : " << i << endl;
//				sum++;
//			}
//		}cout << "so uoc chia het cho " << n << " la " << sum;
//	}
//	else
//		cout << "vui long nhap mot so nguyen duong";*/
//	
//	//int a,b, ucNN;
//	//
//	//cout << "nhap hai so nguyen duong";
//	//cin>> a>> b;
//	//int max = a * b;
//	//*while (a != b) {
//	//	if (a > b) {
//	//		a -= b;
//	//	}
//	//	else
//	//	{
//	//		b -= a;
//	//	}
//	//}
//	//cout <<"uoc chung lon nha la "<< a;*/
//	//
//	//if (b > a)
//	//	ucNN = a;
//	//else
//	//	ucNN = b;
//	//for (int i = ucNN; i <= max; i++) {
//	//	if (i % a == 0 && i % b == 0) {
//	//		cout << "uoc cung nho nhat la " << i;
//	//	}
//	//}
//	
//	/*int n,uc=-1;
//	float tich,t=0, tong = 0;
//	cout << "nhap mot so nguyen n ";
//	cin >> n;
//
//	for (float i = 1; i <= n; i++) {
//		  t += pow(-1,i+1) * i / (i + 1.0);
//		uc *= -1;
//		tich = i + 1;
//		tong += (uc * i / tich) ;
//	}
//	cout << "tong = " << tong << endl;
//	cout << "t = " << t << endl;*/
//
//	/*int n;
//	cout << "nhap mot so nguyen duong ";
//	cin >> n;
//	if (n < 2)
//		cout << "nhap lai so khac ";
//	else
//	{
//		int i = 2;
//		while ( i <= sqrt(n))
//		{
//			if (n % i != 0) {
//				cout << " la so nguyen to";
//			}
//			else
//				cout << "khong la so nguyen to";
//			i++;
//		}
//		if (sqrt(n) < 2) {
//			cout << "la so nguyen to";
//		}
//	}*/
//	
//	/*int n, i, sum = 0;
//	cout << "nhap so n ";
//	cin >> n;
//	for (int i = 1; i <= n; i++)
//	{
//		sum += i*(i+1);
//	}
//	cout << "tong can tinh la " << sum;*/
//
//	/*int n,i=1,sum=0;
//	do
//	{
//		cout << "nhap n ";
//		cin >> n;
//		do {
//			sum += i * (i + 1);
//			i++;
//			continue;
//			cout << "tong = " << sum<<endl;
//		} while (i <= n);
//
//	} while (n>0 && n<100);*/
//
//	//int a; float i=1, tong = 0;
//	//cout << "nhap mot so nguyen duong n ";
//	//cin >> a;
//	//if (a <= 0) {
//	//	cout << "so nguyen nhap vao <= 0 ";
//	//}
//	//else
//	//{
//	//	/*for (float i = 1; i <= a; i++)
//	//	{
//	//		tong += i / (i + 1);
//	//	}*/
//	//	/*while (i<=a)
//	//	{
//	//		tong += i / (i + 1);
//	//		i++;
//	//	}*/
//	//	do
//	//	{
//	//		tong += i / (i + 1);
//	//		i++;
//	//	} while (i<=a);
//	//	cout << "tong = " << tong;
//	//}
//	 
//	/*int n, tong = 0;
//	cout << "nhap mot so nguyen ";
//	cin >> n;
//		while (n!=0)
//		{
//			n /= 10;
//			tong++;
//		}
//		cout << "so vua nhap co "<<tong<<" chu so";*/
//
//	//int n,uc, tong = 0;
//	//cout << "nhap mot so nguyen ";
//	//cin >> n;
//	//while (n!=0)
//	//{
//	//	uc=n % 10;
//	//	tong += uc;
//	//	n /= 10;
//	//}
//	//cout << "tong cac chu so (vd 12=1+2) "<<tong;
//	//return 0;
// }