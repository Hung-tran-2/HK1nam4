#include"Header.h"
using namespace std;
//void NhapTT1ThangSV(SinhVien &sv) {
//	fflush(stdin);//xoa bo diem
//	cout << "Nhap ho ten 1 sinh vien :";
//	getline(cin, sv.HoTen);
//	cout << "nhap MSSV 1 sinh vien : ";
//	getline(cin, sv.MSSV);
//	cout << "nhap diem 1 sinh vien : ";
//	cin >> sv.diem;
//}
//void XuatTT1ThangSV(SinhVien sv) {
//	cout << "Xuat ho ten sinh vien " << sv.HoTen<<endl;
//	cout << "Xuat MSSV sinh vien " << sv.MSSV << endl;
//	cout << "Xuat diem sinh vien " << sv.diem<<endl;
//}
//void khoiTao(DaySo &x) {
//	x.n = 0;
//}
//int kiemTraRong(DaySo x) {
//	return (x.n == 0 ? 1 : 0);
//}
//int kiemTraDay(DaySo x) {
//	return (x.n == MAX ? 1 : 0);
//}
//void nhap_DSDac(DaySo &x) {
//	cout << "nhap do dai danh sach dac ";
//	cin >> x.n;
//	for (int i = 0; i < x.n; i++)
//	{	
//		cout << "nhap so phan tu danh sach dac ["<<i<<"] ";
//		cin >> x.ds[i];
//	}
//}
//void xuat_DSDac(DaySo x) {
//	for (int i = 0; i < x.n; i++)
//	{
//		cout << x.ds[i] << " "; 
//	}
//}
//void chen_ViTri(DaySo &x, int pos, int a) {
//	if (pos<0 || pos>x.n)
//		cout << "\n Vi Tri " << pos << " khong hop le ";
//	else
//		if (kiemTraRong(x) == 1) {
//			if (pos == 0) {
//				x.n++;
//				x.ds[0] = a;
//
//			}
//		}
//		else if (kiemTraDay(x) == 1)
//			cout << "\n Danh sach day";
//		else {
//			x.n++;
//			for (int i = x.n - 1; i >= pos; i--)
//			{
//				x.ds[i + 1] = x.ds[i];
//			}	x.ds[pos] = a;
//		}
//}
//void xoa_ViTri(DaySo& x, int pos) {
//	if (pos<0 || pos>x.n - 1)
//		cout << "vi tri " << pos << " khong hop le";
//	else
//	{
//		if (kiemTraRong(x))cout << "danh sach rong ";
//		else
//		{
//			for (int i = pos; i <=x.n ; i++)
//				x.ds[i] = x.ds[i+1];
//			x.n--;
//		}
//	}
//}
//void printIntegerList(int n){
//	cout << "the list of" << n << "fist integers";
//	for (int i = 1; i <= n; i++)
//	{
//		cout << i;
//	}
//}

//void chuyen_ChuHoa(char chuoi[]) {//on tap mang, cấu trúc, giả thuật tìm kiếm
//	for (unsigned int i = 0; i < strlen(chuoi); i++)
//	{
//		chuoi[i] = toupper(chuoi[i]);
//	}
//}
//void chuanHoa_chuoi(char chuoi[]) {
//	unsigned int i;
//	while (chuoi[0] == ' ')
//	{
//		for (unsigned int j = 1; j < strlen(chuoi); j++)
//		
//			chuoi[j - 1] = chuoi[j];
//			chuoi[strlen(chuoi) - 1] = '\0';
//		
//	}
//	while (chuoi[strlen(chuoi) - 1] == ' ') {
//		chuoi[strlen(chuoi) - 1] = '\0';
//	}
//	for (i = 0; i < strlen(chuoi); i++)
//	{
//		if (chuoi[i] == ' ') {
//			while (chuoi[i + 1] == ' ')
//			{
//				for (unsigned int j = i + 1; j < strlen(chuoi); j++)
//				{
//					chuoi[j] = chuoi[j + 1];
//					chuoi[strlen(chuoi)] = '\0';
//				}
//			}
//		}
//	}
//}
//int timKiemtuantu(int a[], int n, int x) {
//	for (int i = 0; i < n; i++)
//	{
//		if (a[i] == x) {
//			return i;
//		}
//	}return -1;
//}
//
//int timKiemNhiPhan(int a[], int n, int x) {
//	int bottom = 0, top = n - 1, mid;
//	while(bottom <= top)
//	{
//		mid = (bottom + top) / 2;
//		if (a[mid] == x)
//			return mid;
//		else if (x < a[mid])
//			top = mid - 1;
//		else
//			bottom = mid + 1;
//	}
//	return -1;
//}
// 
//void nhapMang(int a[], int& n) {
//	cout << "nhap phan tu cua mang : ";
//	for (int i = 0; i < n; i++)
//	{
//		cin >> a[i];
//	}
//}
//void xuatMang(int a[], int n) {
//	cout << "cac phan tu cua mang vua nhap la : ";
//	for (int i = 0; i < n; i++)
//	{
//		cout << a[i]<<" ";
//	}
//}
// void sapXep(int array[], int n) {
//	for (int i = 0; i < n - 1; i++) {
//		for (int j = i+1; j < n; j++)
//		{
//			if (array[j] < array[i]) {
//				int tam = array[i];
//				array[i] = array[j];
//				array[j] = tam;
//				cout << array[i] << " " << array[j] << endl;
//			}
//		}
//	}
//}

//phần mảng 1 chiều và truyền tham biến
//void nhapPhanTuCuaMang(int &n) {
//	do
//	{
//		cout << "nhap phan tu cua mang ";
//		cin >> n;
//	} while (n > 100 || n<0);
//}
//void nhapMang(int b[],int n) {
//	for (int i = 0; i < n; i++)
//	{
//		cout << "nhap phan tu thu b[" << i<<"] ";
//		cin >> b[i];
//	}
// }
//void xuatMang(int b[],int n) {
//	cout << "cac phan tu cua mang la ";
//	for (int i = 0; i < n; i++)
//	{
//		cout << b[i]<<"  ";
//	}
//}
// int kt_SoHoanThien(int n) {
//	int sum = 0;
//	for (int i = 1; i < n; i++)
//	{
//		if (n % i == 0)
//			sum += i;
//	}
//	if (n == sum)
//		return 1;
//	return 0;
//}
// void dem_SoHoanThien(int a[], int b) {
//	for (int i = 0; i < b; i++)
//	{
//		if(kt_SoHoanThien(a[i])==1)
//		 cout<<"\ncac so hoan thien la "<<a[i]<<endl;
//	}
//}
// int tong_PTD(int a[], int b) {
//	 int sum = 0;
//	 for (int i = 0; i < b; i++)
//	 {
//		 if (a[i] > 0)
//			 sum += a[i];
//	 }return sum;
// }
// int tim_max(int a[], int n) {
//	 int max = a[0];
//	 for (int i = 0; i < n; i++)
//	 {
//		 if (max < a[i])
//			 max = a[i];
//	 }return max;
// }
// bool nt(int b) {
//	 for (int i = 2; i < b; i++)
//	 {
//		 if (b % i == 0)
//			 return false;
//	 }
//	 return true ;
// }
// int demsNt12(int a[], int b) {
//	 for (int i = 0; i < b; i++)
//	 {
//		 if (nt(a[i]))
//			 cout << a[i];
//	 }return 0;
// }
// int dem_So_PhanTuAm(int a[], int n) {
//	 int dem = 0;
//	 for (int i = 0; i < n; i++)
//	 {
//		 if (a[i] < 0) {
//			 dem++;
//		 }
//	 }return dem;
// } 
// int boiCua3(int a[], int n) {
//	 int demboi3 = 0;
//	 for (int i = 0; i < n; i++)
//	 {
//		 if (a[i] % 3 == 0) {
//			 demboi3++;
//		 }
//	 }return demboi3;
// } 
// void xuat_SoChan(int a[], int n) {
//	 for (int i = 0; i < n; i++)
//	 {
//		 if (a[i] % 2 == 0) {
//			 cout << a[i] << " ";
//		 }
//	 }cout << endl;
// }
// void xuat_SoLe(int a[], int n) {
//	 for (int i = 0; i < n; i++)
//	 {
//		 if (a[i] % 2 != 0) {
//			 cout << a[i] << " ";
//		 }
//	 }cout << endl;
// }
// int tong_BoiS7(int a[], int b) {
//	 int sum = 0;
//	 for (int i = 0; i < b; i++)
//	 {
//		 if (a[i] > 0)
//			 sum += a[i];
//	 }return sum % 7;
// } 
// int tong_SoNguyenTo(int a[], int b) {
//	 int tong = 0;
//	 for (int i = 0; i < b; i++)
//	 {
//		 if (nt(a[i])) {
//			 tong += a[i];
//		 }
//	 }return tong;
// }
// void xuat_PTChanNhoHon20(int a[], int n) {
//	 for (int i = 0; i < n; i++)
//	 {
//		 if (a[i] % 2 == 0 && a[i] < 20) {
//			 cout << a[i] << " " << endl;
//		  }
//	 }
// }
// int kt_SoChinhPhuong(int n) {
//	 int kequa = 0;
//	 for (int i = 0; i <=sqrt(n); i++)
//	 {	
//
//		 if (i * i == n)
//			 return true;
//	 }
// }
// void xuat_SoChinhPhuongVTLe(int a[], int n) {
//	 for (int i = 0; i < n; i++)
//	 {			 
//		 if (kt_SoChinhPhuong(a[i])==true && i % 2 == 1) {
//			 cout << a[i] << "  ";
//		 }
//	 }
// }

//ch??ng ham và truy?n tham chi?u
//void duyetNguoc_lietKSN(int n) {
//	for (int i = n; i > 0; i--)
//	{
//		cout << i << "  ";
//	}
//}
//void duyetXuoi_lietKSN(int n) {
//	for (int i = 1; i <= n; i++)
//	{
//		cout << i << "  ";
//	}
//}
//void capNhat(int a, int b) {
//	if (a > b && a % 3 == 0) {
//		a += b - 3;
//	}if (b > 5) {
//		b += b / 5;
//	}
//	cout << a << "  " << b;
//}
//void in_TGS(int height) {
//	for (int i = height; i > 0; i--)
//	{
//		duyetXuoi_lietKSN(i);
//		//duyetNguoc_lietKSN(i);
//		cout << endl;
//	}
//}
//void in_TamGiacBenPhai(int n) {
//	for (int i = 1; i <= n; i++) {
//		for (int j = 1; j <= n; j++) {
//			(i == n || j == n || j > n - i) ? cout << j : cout << " ";
//
//		}
//	}
//}
//void hoanvi(int& a, int& b) {
//	int  t = a;
//	a = b;
//	b = t;
//}
//void nhap_SN(int& n) {
//	do {
//		cin >> n;
//	} while (n < 0);
//}
//long tinh_SN(int n) {
//	int tong = 0;
//	for (int i = 1; i <= n; i++)
//	{
//		tong += i;
//	}return tong;
//}
//int tinh_NghiemPT_bac1(int a, int b, float& c) {
//	if (a == 0) {
//		if (b == 0)
//			return 0;
//		else
//			return -1;
//	}
//	else {
//		c = (float)-b / a;
//		return 1;
//	}
//
//}
//void nhapSoNguyenDuong(int& n) {
//	do {
//		cout << "nhap so nguyen duong ";
//		cin >> n;
//	} while (n <= 0);
//}
//int kt_SoNguyenTo(int n) {
//	if (n < 2)
//		return 0;
//	for (int i = 2; i < n; i++) {
//		if (n % i == 0)
//			return 0;
//	}
//	return 1;
//}
//int kt_1SCP(int n) {
//	for (int i = 1; i <= sqrt(n); i++)
//	{
//		if (sqrt(n) == i)
//			return 1;
//	}return 0;
//
// }
//void nhapSND(int& n) {
//	do {
//		cout << "nhap so nguyen duong ";
//		cin >> n;
//	} while (n > 5 || n <= 0);
//}
//void dem_SCvaSl(int n) {
//	int chan = 0, le = 0;
//	for (int i = 1; i <= n; i++)
//	{
//		if (i % 2==0)
//			chan++;
//		else
//		{
//			le++;
//		}
//	}
//	cout << "so chan la " << chan << " so le la " << le;
//}
//bool kt_SNT(int n) {
//	if (n < 2)
//		return false;
//	if (n % 2 == 0) {
//		return false;
//	}
//	return true;
//}
//int dem_SNT(int n) {
//	int dem = 0;
//	for (int i = 1; i <=n; i++)
//	{
//		if (kt_SNT(i) == true)
//			dem++;
//	}
//	return dem;
//}
////
//void nhap3SN(int& m, int& n, int& l) {
//	cin >> m >> n >> l;
//}
//void nhap3NTK(int &a, float &b, char &c) {
//	cin >> a >> b >> c;
//}
//void xuat3NTK(int a, float b, char c) {
//	cout << "\n" << a << " " << b << " " << c;
//}
//void sapxep(int m,int n ,int l) {
//	int max;
//	if (m > n) {
//		max = m;
//		m = n;
//		n = max;
//	}
//	if (m > l) {
//		max = m;
//		m = l;
//		l = max;
//	}
//	if (n > l) {
//		max = n;
//		n = l;
//		l = max;
//	}
//	cout << m << "," << n << "," << l << endl;
//	cout << l << "," << n << "," << m << endl;
//}
//void nhap2SN(int& a, int& b) {
//	cin >> a >> b;
//}
//void tinhTHTT(int a, int b) {// tinh tong hieu tich thuong
//	cout << "tong = " << a + b << endl;
//	cout << "hieu = " << a - b << endl;
//	cout << "tich = " << a * b << endl;
//	cout << "thuong = " << a / b << endl;
//}
//void tongVTB(int a, int b){//tong va trung binh hai so nguyen vua nhap
//	cout << "tong = " << a + b<<endl;
//	cout << "trung binh = " << (a + b) / 2;
//}
//void nhapVT(int& a, int& b, int& c) {//nhap van toc dau, gia toc, thoi gian
//	cin >> a >> b >> c;
//}
//void tinhVTC(int a, int b, int c) {
//	cout << "van toc cuoi " << a + (b * c);
//}