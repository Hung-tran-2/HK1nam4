#pragma once
#include<iostream>
#include<string>
#include<cctype>
using namespace std;
struct SinhVien
{
	string HoTen;
	string MSSV;
	float diem;
};
typedef struct SinhVien SinhVien;
void NhapTT1ThangSV(SinhVien& sv);
void XuatTT1ThangSV(SinhVien sv);
const int MAX=50;
struct DaySo
{
	int ds [MAX];
	int n;
};
typedef struct DaySo DaySo;
void khoiTao(DaySo &x);
int kiemTraRong(DaySo x);
int kiemTraDay(DaySo x);
void nhap_DSDac(DaySo& x);
void xuat_DSDac(DaySo x);
void chen_ViTri(DaySo& x, int pos, int a);
void xoa_ViTri(DaySo& x, int pos);

//const int MAX = 10;//ôn tập mảng, cấu trúc và giải thuật tìm kiếm
//void chuyen_ChuHoa (char chuoi[]);
//void chuanHoa_chuoi(char chuoi[]);
//void nhapMang(int a[], int& n);
//void xuatMang(int a[], int n);
//int timKiemtuantu(int a[], int n, int x);
//int timKiemNhiPhan(int a[], int n, int x);
//void sapXep(int array[], int n);

//phần mảng một chiều và truyền tham biến
//const int KTM = 30;
//void nhapPhanTuCuaMang(int& n);
//void nhapMang(int b[], int n);
//void xuatMang(int b[], int n);
//int kt_SoHoanThien(int n);
//void dem_SoHoanThien(int a[], int b);
//int tong_PTD(int a[], int b);
//int tim_max(int a[], int n);
//bool nt(int b);
//int demsNt12(int a[], int b);
//int boiCua3(int a[], int n);
//void xuat_SoChan(int a[], int n);
//void xuat_SoLe(int a[], int n);
//int tong_BoiS7(int a[], int b);
//int tong_SoNguyenTo(int a[], int b);
//void xuat_PTChanNhoHon20(int a[], int n);
//int kt_SoChinhPhuong(int n);
//void xuat_SoChinhPhuongVTLe(int a[], int n);
//chương hàm và truyen tham chiếu
//void duyetNguoc_lietKSN(int n);
//void duyetXuoi_lietKSN(int n);
//void capNhat(int a, int b);
//void in_TGS(int height);
//void hoanvi(int& a, int& b);
//void nhap_SN(int& n);
//long tinh_SN(int n);
//int tinh_NghiemPT_bac1(int a, int b, float& c);
//void nhapSoNguyenDuong(int& n);
//int kt_SoNguyenTo(int n);
//void tinh_DTvaCV(int n);
//int kt_1SCP(int n);
//void nhapSND(int& n);
//void dem_SCvaSl(int n);
//int dem_SNT(int n);
//bool kt_SNT(int n);

//void nhap3SN(int& m, int& n, int& l);
//void sapxep(int m, int n, int l);
//void nhap3SN(int& m, int& n, int& l);
//void nhap3NTK(int& a, float& b, char& c);
//void xuat3NTK(int a, float b, char c);
//void tinhTHTT(int a, int b);
//void nhap2SN(int& a, int& b);
//void tongVTB(int a, int b);
//void nhapVT(int& a, int& b, int& c);
//void tinhVTC(int a, int b, int c);